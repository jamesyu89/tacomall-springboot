package cn.tacomall.tacomallspringbootapiportal.service.user;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.tacomall.tacomallspringbootentity.user.User;

public interface UserService extends IService<User> {
    int createUser(String username, String password);
    void updateUser();
    void readUser();
    void deleteUser();
}
