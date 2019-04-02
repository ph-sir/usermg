package com.pengh.usermg.service;

import com.pengh.usermg.entity.PageBean;
import com.pengh.usermg.entity.User;

import java.util.List;

/**
 * @author PENGHUI
 * @date create on 2019/3/25
 */
public interface UserService {

    Integer save(User user);

    User get(Long id);

    void update(User user);

    void delete(Long id);

    User getUserByLoginName(String loginName);

    List<User> list();

    PageBean<User> getUserByPage(int currentPage, int pageSize, String vusername);

    List<User> getUserByOrg(Long id);

    User getUserByOrgIdAndUserId(Long orgId, Long userId);
}
