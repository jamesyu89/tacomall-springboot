package cn.tacomall.tacomallspringbootservice.user;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.tacomall.tacomallspringbootentity.user.User;

public interface UserService extends IService<User> {
    void addUser(User user);
}
