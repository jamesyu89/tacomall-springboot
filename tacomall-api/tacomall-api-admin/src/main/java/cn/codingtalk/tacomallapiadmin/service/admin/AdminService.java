package cn.codingtalk.tacomallapiadmin.service.admin;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.codingtalk.tacomallentity.admin.Admin;

public interface AdminService extends IService<Admin> {

    String login(String username, String password) throws Exception;

    String logout();
}
