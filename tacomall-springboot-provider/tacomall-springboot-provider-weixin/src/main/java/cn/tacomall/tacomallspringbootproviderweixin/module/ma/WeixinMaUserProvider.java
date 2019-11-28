package cn.tacomall.tacomallspringbootproviderweixin.module.ma;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import me.chanjar.weixin.common.error.WxErrorException;

import cn.tacomall.tacomallspringbootutils.JsonUtil;
import cn.tacomall.tacomallspringbootproviderweixin.config.MaConfig;


public class WeixinMaUserProvider {

    private String appid;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public WeixinMaUserProvider(String string) {
        appid = string;
    }

    public String login(String code) {
        if (StringUtils.isBlank(code)) {
            return "empty jscode";
        }

        final WxMaService wxService = MaConfig.getMaService(appid);

        try {
            WxMaJscode2SessionResult session = wxService.getUserService().getSessionInfo(code);
            this.logger.info(session.getSessionKey());
            this.logger.info(session.getOpenid());
            //TODO 可以增加自己的逻辑，关联业务相关数据
            return JsonUtil.toJson(session);
        } catch (WxErrorException e) {
            this.logger.error(e.getMessage(), e);
            return e.toString();
        }
    }

    public String info(String sessionKey,
                       String signature,
                       String rawData,
                       String encryptedData,
                       String iv) {
        final WxMaService wxService = MaConfig.getMaService(appid);

        // 用户信息校验
        if (!wxService.getUserService().checkUserInfo(sessionKey, rawData, signature)) {
            return "user check failed";
        }

        // 解密用户信息
        WxMaUserInfo userInfo = wxService.getUserService().getUserInfo(sessionKey, encryptedData, iv);

        return JsonUtil.toJson(userInfo);
    }

    public String phone(String sessionKey,
                        String signature,
                        String rawData,
                        String encryptedData,
                        String iv) {
        final WxMaService wxService = MaConfig.getMaService(appid);

        // 用户信息校验
        if (!wxService.getUserService().checkUserInfo(sessionKey, rawData, signature)) {
            return "user check failed";
        }

        // 解密
        WxMaPhoneNumberInfo phoneNoInfo = wxService.getUserService().getPhoneNoInfo(sessionKey, encryptedData, iv);

        return JsonUtil.toJson(phoneNoInfo);
    }

}
