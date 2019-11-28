package cn.tacomall.tacomallspringbootapiportal.service.user;

import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.tacomall.tacomallspringbootentity.user.User;

public interface UserService extends IService<User> {
    Map<String, Object> create(String username, String password);
    boolean replace();
    Map<String, Object> get();
    boolean delete();
}
