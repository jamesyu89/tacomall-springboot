package cn.tacomall.tacomallspringbootserviceimpl.user;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.tacomall.tacomallspringbootentity.user.User;
import cn.tacomall.tacomallspringbootmapper.user.UserMapper;
import cn.tacomall.tacomallspringbootservice.user.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public void addUser(User user) {
        baseMapper.insert(user);
    }

}
