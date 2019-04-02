package com.pengh.usermg.controller;

import com.pengh.usermg.entity.Org;
import com.pengh.usermg.entity.User;
import com.pengh.usermg.service.OrgService;
import com.pengh.usermg.service.UserService;
import com.pengh.usermg.util.ResultUtil;
import com.pengh.usermg.vo.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author PENGHUI
 * @date create on 2019/3/27
 */
@RestController
@RequestMapping("/orgs")
public class OrgController {

    @ApiOperation(value = "获取所有组织")
    @GetMapping("")
    public Result<Org> getUserList(@RequestParam(required = false) String orgName) {
        List<Org> orgList = orgService.list(orgName);
        return ResultUtil.success(orgList);
    }

    @ApiOperation(value = "获取组织下所有人员", notes = "根据Url中的组织id获取组织下的人员")
    @ApiImplicitParam(name = "id", value = "组织ID", required = true, dataType = "Long")
    @GetMapping("/{id}/users")
    public Result<User> getUserByOrg(@PathVariable Long id) {
        List<User> userList = userService.getUserByOrg(id);
        return ResultUtil.success(userList);
    }

    @ApiOperation(value = "获取组织下指定人员", notes = "根据Url中的组织id和人员id，获取组织下的指定人员")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orgId", value = "组织ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "userId", value = "人员ID", required = true, dataType = "Long")
    })
    @GetMapping("/{orgId}/users/{userId}")
    public Result<User> getUserByOrg(@PathVariable Long orgId, @PathVariable Long userId) {
        User user = userService.getUserByOrgIdAndUserId(orgId, userId);
        return ResultUtil.success(user);
    }

    @Autowired
    private OrgService orgService;

    @Autowired
    private UserService userService;

}
