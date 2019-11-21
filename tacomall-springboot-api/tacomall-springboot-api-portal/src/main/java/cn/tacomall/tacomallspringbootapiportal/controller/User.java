package cn.tacomall.tacomallspringbootapiportal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.annotations.*;

import cn.tacomall.tacomallspringbootcommon.dto.ResponseDto;
import cn.tacomall.tacomallspringbootutils.RequestUtil;
import cn.tacomall.tacomallspringbootutils.ResponseUtil;
import cn.tacomall.tacomallspringbootapiportal.annotation.IgnoreAuth;

@Api(tags = "portal domain and index module")
@RestController
@RequestMapping(value = "/portal/user/")
public class User {
    @ApiOperation(value = "register", notes = "user register method", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "verify code", required = true, paramType = "path"),
    })
    @IgnoreAuth
    @PostMapping("register")
    public ResponseDto register(@RequestBody RequestUtil jsonRequest, ResponseUtil responseUtil) throws Exception {
        String code = jsonRequest.getStr("code");
        return responseUtil.success(code);
    }

    @ApiOperation(value = "login", notes = "user login method", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "verify code", required = true, paramType = "path"),
    })
    @IgnoreAuth
    @PostMapping("login")
    public ResponseDto index(@RequestBody RequestUtil jsonRequest, ResponseUtil responseUtil) throws Exception {
        String code = jsonRequest.getStr("code");
        return responseUtil.success(code);
    }
}
