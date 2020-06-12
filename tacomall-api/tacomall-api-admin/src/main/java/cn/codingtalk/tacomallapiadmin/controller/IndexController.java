/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-06-12 20:57:57
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: \tacomall-springboot\tacomall-api\tacomall-api-admin\src\main\java\cn\codingtalk\tacomallapiadmin\controller\IndexController.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapiadmin.controller;

import cn.codingtalk.tacomallapiadmin.service.admin.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.codingtalk.tacomallcommon.vo.ResponseVo;
import cn.codingtalk.tacomallapiadmin.annotation.LoginLogger;

@RestController
@RequestMapping(value = "/admin/index/")
public class IndexController {

    @Autowired
    private AdminUserService adminUserService;

    @LoginLogger("用户登录")
    @PostMapping("login")
    public ResponseVo<String> login(@RequestParam(value = "username") String username,
                            @RequestParam(value = "passwd") String passwd) {
        return adminUserService.login(username, passwd);
    }
}
