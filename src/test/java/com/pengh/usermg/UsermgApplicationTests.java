package com.pengh.usermg;

import com.pengh.usermg.entity.User;
import com.pengh.usermg.redis.RedisUtil;
import com.pengh.usermg.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UsermgApplicationTests {

    @Test
    public void test() {
        stringRedisTemplate.opsForValue().set("test", "123");
        Assert.assertEquals("123", stringRedisTemplate.opsForValue().get("test"));
    }

    @Test
    public void saveUserToRedis() {
        User user = userService.get(1L);
        redisUtil.set("user", user);
        System.out.println("存储成功");
        User u = (User) redisUtil.get("user");
        System.out.println("取出成功");
        System.out.println(u.getLoginName());
    }

    @Test
    public void redisCache() {
        User u = userService.get(2L);
        User user = userService.get(2L);
    }

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private UserService userService;


}
