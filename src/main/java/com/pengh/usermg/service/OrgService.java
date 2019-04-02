package com.pengh.usermg.service;

import com.pengh.usermg.entity.Org;

import java.util.List;

/**
 * @author PENGHUI
 * @date create on 2019/3/27
 */
public interface OrgService {

    Integer save(Org org);

    void update(Org org);

    void delete(Long id);

    List<Org> list(String orgName);


}
