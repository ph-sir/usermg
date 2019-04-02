package com.pengh.usermg.util;

import com.pengh.usermg.entity.User;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author PENGHUI
 * @date create on 2019/3/28
 */
public class ShiroMd5Util {

    /**
     * 加密方式
     */
    public static final String HASH_ALGORITHM_NAME = "MD5";

    /**
     * 加密1024次
     */
    public static final int HASH_ITERATIONS = 1024;

    //添加user的密码加密方法
    public static String SysMd5(User user) {
        Object crdentials = user.getPassword();
        //以账号作为盐值
        ByteSource salt = ByteSource.Util.bytes(user.getLoginName());
        SimpleHash hash = new SimpleHash(HASH_ALGORITHM_NAME, crdentials, salt, HASH_ITERATIONS);
        return hash.toString();
    }


}
