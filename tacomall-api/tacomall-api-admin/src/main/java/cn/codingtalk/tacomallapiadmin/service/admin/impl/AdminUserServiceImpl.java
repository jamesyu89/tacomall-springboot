/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-06-12 17:57:19
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: \tacomall-springboot\tacomall-api\tacomall-api-admin\src\main\java\cn\codingtalk\tacomallapiadmin\service\admin\impl\AdminUserServiceImpl.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapiadmin.service.admin.impl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.codingtalk.tacomallentity.admin.AdminUser;
import cn.codingtalk.tacomallapiadmin.service.admin.AdminUserService;
import cn.codingtalk.tacomallmapper.admin.AdminUserMapper;
import cn.codingtalk.tacomallcommon.vo.ResponseVo;

@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser> implements AdminUserService {

    @Override
    public ResponseVo<String> login(String username, String password) {
        ResponseVo<String> responseVo = new ResponseVo<>();
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken adminUser = new UsernamePasswordToken(username, password);
            subject.login(adminUser);
            String authorization = (String) subject.getSession().getId();
            responseVo.setData(authorization);
        } catch (IncorrectCredentialsException e) {

        } catch (LockedAccountException e) {
        } catch (AuthenticationException e) {
        }
        return responseVo;
    }

    @Override
    public ResponseVo<String> logout() {
        ResponseVo<String> responseVo = new ResponseVo<>();
        return responseVo;
    }

}
