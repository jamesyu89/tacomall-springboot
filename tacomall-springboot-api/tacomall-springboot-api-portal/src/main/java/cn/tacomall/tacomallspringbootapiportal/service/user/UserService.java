package cn.tacomall.tacomallspringbootapiportal.service.user;

import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.tacomall.tacomallspringbootentity.user.User;

public interface UserService extends IService<User> {
    Map<String, Object> register(String username, String password) throws Exception;
    Map<String, Object> login(String username, String password);
    Map<String, Object> miniAppLogin(String iv, String code, String encryptedData);
    Map<String, Object> synopsis();
}
