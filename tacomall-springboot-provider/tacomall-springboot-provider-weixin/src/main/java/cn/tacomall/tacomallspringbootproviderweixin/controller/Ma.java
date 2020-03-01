package cn.tacomall.tacomallspringbootproviderweixin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.*;
import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import me.chanjar.weixin.common.error.WxErrorException;

import cn.tacomall.tacomallspringbootcommon.utils.RequestUtil;
import cn.tacomall.tacomallspringbootcommon.utils.ResponseUtil;
import cn.tacomall.tacomallspringbootcommon.dto.ResponseDto;
import cn.tacomall.tacomallspringbootproviderweixin.config.MaConfig;


@RestController
@RequestMapping(value = "/weixin/ma/")
public class Ma {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("login")
    public ResponseDto login(@RequestBody RequestUtil requestUtil, ResponseUtil responseUtil) throws Exception {

        String appid = requestUtil.getStr("appid");
        String iv = requestUtil.getStr("iv");
        String encryptedData = requestUtil.getStr("encryptedData");
        String code = requestUtil.getStr("code");

        System.out.println(code);

        final WxMaService wxService = MaConfig.getMaService(appid);

        try {
            WxMaJscode2SessionResult session = wxService.getUserService().getSessionInfo(code);
            this.logger.info(session.getSessionKey());
            this.logger.info(session.getOpenid());
            WxMaUserInfo userInfo = wxService.getUserService().getUserInfo(session.getSessionKey(), encryptedData, iv);
            return responseUtil
                    .data(userInfo)
                    .success();
        } catch (WxErrorException e) {
            return responseUtil.error();
        }
    }

}
