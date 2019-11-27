package cn.tacomall.tacomallspringbootapiportal.serviceimpl.user;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import cn.tacomall.tacomallspringbootutils.PasswordUtil;
import cn.tacomall.tacomallspringbootentity.user.User;
import cn.tacomall.tacomallspringbootmapper.user.UserMapper;
import cn.tacomall.tacomallspringbootapiportal.service.user.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public int createUser(String username, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUsername, username);
        User exitUser = baseMapper.selectOne(queryWrapper);
        if (exitUser.getId() > 0) {
            return 0;
        }
        User newUser = new User();
        String encodePassword = PasswordUtil.encode(password);
        newUser.setUsername(username);
        newUser.setPassword(encodePassword);
        baseMapper.insert(newUser);
        return newUser.getId().intValue();
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
