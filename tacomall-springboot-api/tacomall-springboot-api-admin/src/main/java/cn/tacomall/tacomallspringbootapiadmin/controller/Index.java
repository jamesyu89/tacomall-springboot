package cn.tacomall.tacomallspringbootapiadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import cn.tacomall.tacomallspringbootcommon.utils.RequestUtil;
import cn.tacomall.tacomallspringbootcommon.utils.ResponseUtil;
import cn.tacomall.tacomallspringbootcommon.dto.ResponseDto;
import cn.tacomall.tacomallspringbootcommon.annotation.SysLogger;
import cn.tacomall.tacomallspringbootapiadmin.service.admin.AdminService;

@RestController
@RequestMapping(value = "/admin/index/")
public class Index {

    @Autowired
    private AdminService storeService;

    @SysLogger("用户登录")
    @PostMapping("login")
    public ResponseDto login(@RequestBody RequestUtil jsonRequest, ResponseUtil responseUtil) throws Exception {
        String username = jsonRequest.getStr("username");
        String password = jsonRequest.getStr("password");
        storeService.login(username, password);
        return responseUtil.success();
    }
}
