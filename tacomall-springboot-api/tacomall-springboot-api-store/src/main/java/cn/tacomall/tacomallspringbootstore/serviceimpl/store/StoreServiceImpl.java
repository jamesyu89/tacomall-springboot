package cn.tacomall.tacomallspringbootstore.serviceimpl.store;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import cn.tacomall.tacomallspringbootentity.store.Store;
import cn.tacomall.tacomallspringbootmapper.store.StoreMapper;
import cn.tacomall.tacomallspringbootstore.service.store.StoreService;

@Service
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store> implements StoreService {

    @Autowired
    StoreMapper storeMapper;

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
