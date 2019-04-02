package com.pengh.usermg.shiro;

import com.pengh.usermg.entity.User;
import com.pengh.usermg.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 实现AuthorizingRealm接口用户用户认证
 * @author PENGHUI
 * @date create on 2019/3/25
 */
public class MyShiroRealm extends AuthorizingRealm {

    /**
     * 角色权限和对应权限添加
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 用户认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String loginName = (String) token.getPrincipal();
        User user = userService.getUserByLoginName(loginName);
        if (null == user) {
            throw new UnknownAccountException("用户不存在");
        }
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getLoginName());
        if (1 == user.getLock()) {
            throw new LockedAccountException("账户已被锁定");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getLoginName(), user.getPassword(), credentialsSalt, user.getVusername());
        return info;
    }

    @Autowired
    private UserService userService;
}
