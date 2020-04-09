package cn.codingtalk.tacomallapiadmin.controller;

import cn.codingtalk.tacomallapiadmin.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import cn.codingtalk.tacomallcommon.utils.RequestUtil;
import cn.codingtalk.tacomallcommon.utils.ResponseUtil;
import cn.codingtalk.tacomallcommon.vo.ResponseVo;
import cn.codingtalk.tacomallcommon.annotation.SysLogger;

@RestController
@RequestMapping(value = "/admin/index/")
public class Index {

    @Autowired
    private AdminService storeService;

    @SysLogger("用户登录")
    @PostMapping("login")
    public ResponseVo login(@RequestBody RequestUtil jsonRequest, ResponseUtil responseUtil) throws Exception {
        String username = jsonRequest.getStr("username");
        String password = jsonRequest.getStr("password");
        storeService.login(username, password);
        return responseUtil.success();
    }
}