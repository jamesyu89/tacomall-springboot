package cn.tacomall.tacomallspringbootsecurity.shiro;

import java.util.List;

import com.iterge.entity.SysPermission;
import com.iterge.entity.SysRole;
import com.iterge.entity.User;
import com.iterge.service.SysPermissionService;
import com.iterge.service.SysRoleService;
import com.iterge.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class Realm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysPermissionService sysPermissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        System.out.println("权限认证");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principal.getPrimaryPrincipal();
        System.out.println("**********" + user.toString());
        try {
            List<SysRole> roles = sysRoleService.selectByUid(user.getUid());
            for (SysRole role : roles) {
                authorizationInfo.addRole(role.getRolename());
            }
            List<SysPermission> permissions = sysPermissionService.selectByUid(user.getUid());
            for (SysPermission permission : permissions) {
                authorizationInfo.addStringPermission(permission.getPername());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户账号和密码
        System.out.println("用户认证");
        String username = (String) authenticationToken.getPrincipal();
        User user = userService.login(username);
        if (user == null) {
            return null;
        }
        if (user.getStatus() == 1) { //账户冻结
            throw new LockedAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,//安全数据
                user.getPassword(),//
                getName()
        );
        return authenticationInfo;
    }
}
