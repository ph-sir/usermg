package com.pengh.usermg.controller;

import cn.hutool.core.bean.BeanUtil;
import com.pengh.usermg.entity.PageBean;
import com.pengh.usermg.entity.User;
import com.pengh.usermg.service.UserService;
import com.pengh.usermg.util.ResultUtil;
import com.pengh.usermg.util.ShiroMd5Util;
import com.pengh.usermg.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author PENGHUI
 * @date create on 2019/3/25
 */
@RestController
@RequestMapping("/users")
@Api(value = "用户操作接口")
public class UserController {

    /**
     * @param id
     * @return
     */
    @ApiOperation(value="获取单个用户信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public Result getUser(@PathVariable Long id) {
        User user = userService.get(id);
        return ResultUtil.success(user);
    }

    /**
     * 获取用户列表
     * @return
     */
    @ApiOperation(value = "获取所有用户列表", notes = "获取所有的用户")
    @GetMapping("")
    public Result getUserList() {
        List<User> users = userService.list();
        return ResultUtil.success(users);
    }

    @ApiOperation(value = "分页查询用户列表", notes = "根据Url中的currentPage和pageSize分页查询用户列表")
    @GetMapping("page")
    public Result getUserByPage(@RequestParam int currentPage, @RequestParam int pageSize, @RequestParam String vusername) {
        PageBean<User> pageBean = userService.getUserByPage(currentPage, pageSize, vusername);
        return ResultUtil.success(pageBean);
    }

    /**
     * 创建用户
     * @param user
     * @return
     */
    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户信息实体", required = true, dataType = "User")
    @PostMapping("")
    public Result postUser(@RequestBody User user) {
        user.setPassword(ShiroMd5Util.SysMd5(user));
        userService.save(user);
        return ResultUtil.success("用户创建成功");
    }

    /**
     * 更新单个用户
     * @param userId
     * @param user
     * @return
     */
    @ApiOperation(value = "更新单个用户信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细信息", required = true, dataType = "User")
    })
    @PutMapping("/{id}")
    public Result putUser(@PathVariable("userId") Long userId, @ModelAttribute User user) {
        User u = userService.get(userId);
        BeanUtil.copyProperties(user, u);
        userService.update(u);
        return ResultUtil.success("更新用户成功");
    }

    /**
     * 删除单个用户
     * @param id
     * @return
     */
    @ApiOperation(value = "删除单个用户", notes = "根据Url的id来删除指定用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @DeleteMapping("/{id}")
    public Result deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResultUtil.success("删除用户成功");
    }

    @Autowired
    private UserService userService;
}
