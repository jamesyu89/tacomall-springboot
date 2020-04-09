package cn.codingtalk.tacomallapiopen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import cn.codingtalk.tacomallcommon.utils.RequestUtil;
import cn.codingtalk.tacomallcommon.utils.ResponseUtil;
import cn.codingtalk.tacomallcommon.vo.ResponseVo;
import cn.codingtalk.tacomallapiopen.service.OssService;

@RestController
@RequestMapping(value = "/open/oss")
public class Oss {

    @Autowired
    private OssService ossService;

    @PostMapping("authorize")
    public ResponseVo authorize(@RequestBody RequestUtil jsonRequest, ResponseUtil responseUtil) throws Exception {
        return responseUtil
                .data(ossService.authorize(jsonRequest.getStr("dir")))
                .success();
    }

    @PostMapping("callback")
    public ResponseVo callback(@RequestBody RequestUtil jsonRequest, ResponseUtil responseUtil) throws Exception {
        return responseUtil
                .success();
    }
}
