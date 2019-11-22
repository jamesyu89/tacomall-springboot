package cn.tacomall.tacomallspringbootapiportal.serviceimpl.user;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.tacomall.tacomallspringbootentity.user.User;
import cn.tacomall.tacomallspringbootmapper.user.UserMapper;
import cn.tacomall.tacomallspringbootapiportal.service.user.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public void createUser(String name) {
        User user = new User();
        user.setName(name);
        user.setAge(12);
        user.setEmail("abc@mp.com");
        baseMapper.insert(user);
    }

    @Override
    public void updateUser() {
    }

    @Override
    public void readUser() {
    }

    @Override
    public void deleteUser() {
    }

}
