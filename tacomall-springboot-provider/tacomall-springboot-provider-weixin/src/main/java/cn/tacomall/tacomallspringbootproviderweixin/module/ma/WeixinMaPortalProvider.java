package cn.tacomall.tacomallspringbootproviderweixin.module.ma;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaMessage;
import cn.binarywang.wx.miniapp.constant.WxMaConstants;
import org.apache.commons.lang3.StringUtils;

import cn.tacomall.tacomallspringbootproviderweixin.config.MaConfig;


public class WeixinMaPortalProvider {

    private String appid;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private void route(WxMaMessage message, String appid) {
        try {
            MaConfig.getRouter(appid).route(message);
        } catch (Exception e) {
            this.logger.error(e.getMessage(), e);
        }
    }

    public WeixinMaPortalProvider(String string) {
        appid = string;
    }


    public String authGet(String signature,
                          String timestamp,
                          String nonce,
                          String echostr) {
        this.logger.info("\n接收到来自微信服务器的认证消息：signature = [{}], timestamp = [{}], nonce = [{}], echostr = [{}]", signature, timestamp, nonce, echostr);

        if (StringUtils.isAnyBlank(signature, timestamp, nonce, echostr)) {
            throw new IllegalArgumentException("请求参数非法，请核实!");
        }

        final WxMaService wxService = MaConfig.getMaService(appid);

        if (wxService.checkSignature(timestamp, nonce, signature)) {
            return echostr;
        }

        return "非法请求";
    }

    public String post(String msgSignature,
                       String encryptType,
                       String signature,
                       String timestamp,
                       String nonce,
                       String requestBody) {
        this.logger.info("\n接收微信请求：[msg_signature=[{}], encrypt_type=[{}], signature=[{}]," +
                        " timestamp=[{}], nonce=[{}], requestBody=[\n{}\n] ",
                msgSignature, encryptType, signature, timestamp, nonce, requestBody);

        final WxMaService wxService = MaConfig.getMaService(appid);

        final boolean isJson = Objects.equals(wxService.getWxMaConfig().getMsgDataFormat(),
                WxMaConstants.MsgDataFormat.JSON);
        if (StringUtils.isBlank(encryptType)) {
            // 明文传输的消息
            WxMaMessage inMessage;
            if (isJson) {
                inMessage = WxMaMessage.fromJson(requestBody);
            } else {//xml
                inMessage = WxMaMessage.fromXml(requestBody);
            }

            this.route(inMessage, appid);
            return "success";
        }

        if ("aes".equals(encryptType)) {
            // 是aes加密的消息
            WxMaMessage inMessage;
            if (isJson) {
                inMessage = WxMaMessage.fromEncryptedJson(requestBody, wxService.getWxMaConfig());
            } else {//xml
                inMessage = WxMaMessage.fromEncryptedXml(requestBody, wxService.getWxMaConfig(),
                        timestamp, nonce, msgSignature);
            }

            this.route(inMessage, appid);
            return "success";
        }

        throw new RuntimeException("不可识别的加密类型：" + encryptType);
    }

}
