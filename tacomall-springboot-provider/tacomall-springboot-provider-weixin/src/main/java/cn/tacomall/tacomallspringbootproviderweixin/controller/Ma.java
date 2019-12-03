package cn.tacomall.tacomallspringbootproviderweixin.controller;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.*;
import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import me.chanjar.weixin.common.error.WxErrorException;

import cn.tacomall.tacomallspringbootcommon.dto.ResponseDto;
import cn.tacomall.tacomallspringbootutils.ResponseUtil;
import cn.tacomall.tacomallspringbootutils.StringUtil;
import cn.tacomall.tacomallspringbootutils.JsonUtil;
import  cn.tacomall.tacomallspringbootproviderweixin.config.MaConfig;


@RestController
@RequestMapping(value = "/weixin/ma/{appid}")
public class Ma {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/login")
    public ResponseDto login(@PathVariable String appid, String code, ResponseUtil responseUtil) {
        if (StringUtil.isBlank(code)) {
            return responseUtil.error();
        }

        final WxMaService wxService = MaConfig.getMaService(appid);

        try {
            WxMaJscode2SessionResult session = wxService.getUserService().getSessionInfo(code);
            this.logger.info(session.getSessionKey());
            this.logger.info(session.getOpenid());
            //TODO 可以增加自己的逻辑，关联业务相关数据
            return responseUtil
                    .data(JsonUtil.toJson(session))
                    .success();
        } catch (WxErrorException e) {
            return responseUtil.error();
        }
    }

}
