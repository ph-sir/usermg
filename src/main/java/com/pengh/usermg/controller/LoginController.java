package com.pengh.usermg.controller;

import com.pengh.usermg.entity.User;
import com.pengh.usermg.service.UserService;
import com.pengh.usermg.util.ResultUtil;
import com.pengh.usermg.vo.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author PENGHUI
 * @date create on 2019/3/26
 */
@Controller
public class LoginController {

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody Map params, HttpServletResponse response){
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(
                params.get("loginName").toString(),
                params.get("password").toString());
        try {
            currentUser.login(token);
        } catch (IncorrectCredentialsException e) {
            return ResultUtil.loginFail("用户名或密码不正确");
        } catch (UnknownAccountException e) {
            return ResultUtil.loginFail("未知账户");
        } catch (LockedAccountException e) {
            return ResultUtil.loginFail("密码错误次数太多，账户已锁定");
        } catch (ExcessiveAttemptsException e) {
            return ResultUtil.loginFail("用户名或密码错误次数太多");
        } catch (AuthenticationException e) {
            return ResultUtil.loginFail("用户名或密码不正确");
        }
        if (currentUser.isAuthenticated()) {
            String loginName = currentUser.getPrincipal().toString();
            User user = userService.getUserByLoginName(loginName);
            response.setHeader("Authorization", currentUser.getSession().getId().toString());
            return ResultUtil.success(user);
        }
        token.clear();
        return ResultUtil.loginFail("用户名或密码不正确");
    }

    @Autowired
    UserService userService;

}
