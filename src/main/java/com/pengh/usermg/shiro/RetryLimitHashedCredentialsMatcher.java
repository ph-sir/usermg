package com.pengh.usermg.shiro;

import com.pengh.usermg.entity.User;
import com.pengh.usermg.redis.RedisUtil;
import com.pengh.usermg.service.UserService;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * shiro自定义密码比较器
 * @author PENGHUI
 * @date create on 2019/3/28
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

    private static final String LOGIN_ERROR_PREFIX = "login:error:";

    private static final int MAX_ERROR_NUM = 3;

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String loginName = token.getPrincipal().toString();
        User user = userService.getUserByLoginName(loginName);
        User u = new User();
        u.setUserId(user.getUserId());
        Object value = redisUtil.get(LOGIN_ERROR_PREFIX + user.getLoginName());
        //初始化错误登录次数
        AtomicInteger errorNum = new AtomicInteger(0);
        if (null != value) {
            errorNum = new AtomicInteger(Integer.valueOf(value.toString()));
            if (errorNum.get() > MAX_ERROR_NUM) {
                u.setLock((byte) 1);
                userService.update(u);
                throw new LockedAccountException();
            }
        }
        boolean matches = super.doCredentialsMatch(token, info);
        if (matches) {
            u.setCount((byte) 0);
            userService.update(u);
            //密码匹配成功，重置错误次数
            errorNum = new AtomicInteger(0);
            redisUtil.set(LOGIN_ERROR_PREFIX + user.getLoginName(), errorNum);
        } else {
            redisUtil.set(LOGIN_ERROR_PREFIX + user.getLoginName(), errorNum.incrementAndGet(), 1800);
        }
        return matches;
    }

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtil redisUtil;

}
