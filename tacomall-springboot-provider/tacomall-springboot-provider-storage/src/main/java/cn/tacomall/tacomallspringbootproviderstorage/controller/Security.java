package cn.tacomall.tacomallspringbootproviderstorage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import cn.tacomall.tacomallspringbootcommon.utils.RequestUtil;
import cn.tacomall.tacomallspringbootcommon.utils.ResponseUtil;
import cn.tacomall.tacomallspringbootcommon.dto.ResponseDto;
import cn.tacomall.tacomallspringbootproviderstorage.service.SecurityService;

@RestController
@RequestMapping(value = "/provider/storage/security")
public class Security {

    @Autowired
    private SecurityService securityService;

    @PostMapping("authorize")
    public ResponseDto authorize(@RequestBody RequestUtil jsonRequest, ResponseUtil responseUtil) throws Exception {
        return responseUtil
                .data(securityService.authorize(jsonRequest.getStr("dir")))
                .success();
    }
}
