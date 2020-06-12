/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-06-12 21:30:02
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: \tacomall-springboot\tacomall-api\tacomall-api-admin\src\main\java\cn\codingtalk\tacomallapiadmin\shiro\MyShiroRealm.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapiadmin.shiro;

import java.util.List;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import cn.codingtalk.tacomallentity.admin.AdminUser;
import cn.codingtalk.tacomallentity.admin.AdminUserAuthRule;
import cn.codingtalk.tacomallmapper.admin.AdminUserMapper;

public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    private AdminUserMapper adminUserMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        System.out.println("权限认证");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        AdminUser adminUser = (AdminUser) principal.getPrimaryPrincipal();
        try {
            authorizationInfo.addRole(adminUserMapper.getAuthRole(adminUser.getId()).getName());

            List<AdminUserAuthRule> adminAuthRules = adminUserMapper.getAuthRule(adminUser.getId());
            for (AdminUserAuthRule adminAuthRule : adminAuthRules) {
                authorizationInfo.addStringPermission(adminAuthRule.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authorizationInfo;
    }

    /* 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。 */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        // 获取用户账号和密码
        System.out.println("用户认证");
        String username = (String) authenticationToken.getPrincipal();
        AdminUser adminUser = adminUserMapper
                .selectOne(new QueryWrapper<AdminUser>().lambda().eq(AdminUser::getUsername, username));
        if (adminUser == null) {
            return null;
        }
        if (adminUser.getStatus() == 1) {
            throw new LockedAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(adminUser, // 安全数据
                adminUser.getPasswd(), //
                getName());
        return authenticationInfo;
    }
}
