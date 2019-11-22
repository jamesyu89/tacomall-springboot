package cn.tacomall.tacomallspringbootapiportal.service.user;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.tacomall.tacomallspringbootentity.user.User;

public interface UserService extends IService<User> {
    void createUser(String name);
    void updateUser();
    void readUser();
    void deleteUser();
}
