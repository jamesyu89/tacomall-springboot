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
import cn.tacomall.tacomallspringbootapiportal.annotation.IgnoreAuth;
import cn.tacomall.tacomallspringbootapiportal.service.user.*;

@Api(tags = "用户模块")
@RestController
@RequestMapping(value = "/portal/user/")
public class User {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "注册接口", notes = "用户注册接口", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名称", required = true, paramType = "path"),
    })
    @IgnoreAuth
    @PostMapping("register")
    public ResponseDto register(@RequestBody RequestUtil jsonRequest, ResponseUtil responseUtil) throws Exception {
        String name = jsonRequest.getStr("name");
        userService.createUser(name);
        return responseUtil.success();
    }
}
