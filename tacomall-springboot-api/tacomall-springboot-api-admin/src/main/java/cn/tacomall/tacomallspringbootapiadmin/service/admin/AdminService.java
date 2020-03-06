package cn.tacomall.tacomallspringbootapiadmin.service.admin;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.tacomall.tacomallspringbootentity.admin.Admin;

public interface AdminService extends IService<Admin> {

    String login(String username, String password) throws Exception;

    String logout();
}
