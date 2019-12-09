package cn.tacomall.tacomallspringbootstore.shiro;

import java.util.List;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import cn.tacomall.tacomallspringbootentity.store.Store;
import cn.tacomall.tacomallspringbootentity.store.StorePermission;
import cn.tacomall.tacomallspringbootmapper.store.StoreMapper;

public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    private StoreMapper storeMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        System.out.println("权限认证");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Store store = (Store) principal.getPrimaryPrincipal();
        try {
            authorizationInfo.addRole(storeMapper.getRole().getName());

            List<StorePermission> permissions = storeMapper.getPermission();
            for (StorePermission permission : permissions) {
                authorizationInfo.addStringPermission(permission.getName());
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
        Store store = storeMapper
                .selectOne(new QueryWrapper<Store>()
                        .lambda()
                        .eq(Store::getUsername, username));
        if (store == null) {
            return null;
        }
        if (store.getStatus() == 1) {
            throw new LockedAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                store,//安全数据
                store.getPassword(),//
                getName()
        );
        return authenticationInfo;
    }
}
