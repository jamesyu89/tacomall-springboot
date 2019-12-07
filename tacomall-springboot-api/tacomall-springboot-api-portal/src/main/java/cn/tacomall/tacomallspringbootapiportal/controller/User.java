package cn.tacomall.tacomallspringbootapiportal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.*;

import cn.tacomall.tacomallspringbootcommon.dto.ResponseDto;
import cn.tacomall.tacomallspringbootutils.RequestUtil;
import cn.tacomall.tacomallspringbootutils.ResponseUtil;
import cn.tacomall.tacomallspringbootsecurity.annotation.IgnoreAuth;
import cn.tacomall.tacomallspringbootsecurity.annotation.RequireAuth;
import cn.tacomall.tacomallspringbootapiportal.service.user.*;

@Api(tags = "用户模块")
@RestController
@RequestMapping(value = "/portal/user/")
public class User {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "小程序用户注册接口", notes = "小程序用户注册接口", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "iv", value = "iv", required = true, paramType = "path"),
            @ApiImplicitParam(name = "code", value = "code", required = true, paramType = "path"),
            @ApiImplicitParam(name = "encryptedData", value = "encryptedData", required = true, paramType = "path")
    })
    @IgnoreAuth
    @PostMapping("miniAppLogin")
    public ResponseDto miniAppLogin(@RequestBody RequestUtil requestUtil, ResponseUtil responseUtil) throws Exception {
        String iv = requestUtil.getStr("iv");
        String code = requestUtil.getStr("code");
        String encryptedData = requestUtil.getStr("encryptedData");
        String token = userService.miniAppLogin(iv, code, encryptedData);
        responseUtil.data(token);
        return responseUtil.success();
    }

    @ApiOperation(value = "用户信息", notes = "用户信息接口", httpMethod = "POST")
    @ApiImplicitParams({})
    @RequireAuth
    @PostMapping("synopsis")
    public ResponseDto synopsis(@RequestBody RequestUtil requestUtil, ResponseUtil responseUtil) throws Exception {
        Object user = userService.synopsis();
        responseUtil.data(user);
        return responseUtil.success();
    }
}
