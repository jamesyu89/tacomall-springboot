package cn.tacomall.tacomallspringbootapiadmin.service.admin.impl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import cn.tacomall.tacomallspringbootentity.admin.Admin;
import cn.tacomall.tacomallspringbootmapper.admin.AdminMapper;
import cn.tacomall.tacomallspringbootapiadmin.service.admin.AdminService;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public String login(String username, String password) {
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken store = new UsernamePasswordToken(username, password);
            subject.login(store);
            String authorization = (String) subject.getSession().getId();
        } catch (IncorrectCredentialsException e) {

        } catch (LockedAccountException e) {
        } catch (AuthenticationException e) {
        }
        return "";
    }

    @Override
    public String logout() {
        return "";
    }

}
