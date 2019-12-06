package cn.tacomall.tacomallspringbootapiportal.service.user;

import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.tacomall.tacomallspringbootentity.user.User;

public interface UserService extends IService<User> {

    String miniAppLogin(String iv, String code, String encryptedData) throws Exception;

    Object synopsis();
}
