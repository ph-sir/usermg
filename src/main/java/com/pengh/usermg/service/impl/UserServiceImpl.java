package com.pengh.usermg.service.impl;

import com.github.pagehelper.PageHelper;
import com.pengh.usermg.dao.UserMapper;
import com.pengh.usermg.entity.PageBean;
import com.pengh.usermg.entity.User;
import com.pengh.usermg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author PENGHUI
 * @date create on 2019/3/25
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Override
    public Integer save(User user) {
        user.setGenTime(new Date());
        return userMapper.insert(user);
    }

    @Override
    public User get(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void delete(Long id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User getUserByLoginName(String loginName) {
        return userMapper.selectByLoginName(loginName);
    }

    @Override
    public List<User> list() {
        return userMapper.selectAll(null);
    }

    @Override
    public PageBean<User> getUserByPage(int currentPage, int pageSize, String vusername) {
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
        PageHelper.startPage(currentPage, pageSize);
        List<User> userList = userMapper.selectAll(vusername);
        int countNums = userMapper.countUser(vusername);
        PageBean<User> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setData(userList);
        return pageData;
    }

    @Override
    public List<User> getUserByOrg(Long id) {
        return userMapper.selectByOrgId(id);
    }

    @Override
    public User getUserByOrgIdAndUserId(Long orgId, Long userId) {
        return userMapper.selectByOrgIdAndUserId(orgId, userId);
    }

    @Autowired
    private UserMapper userMapper;
}
