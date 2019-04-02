package com.pengh.usermg.service.impl;

import com.pengh.usermg.dao.OrgMapper;
import com.pengh.usermg.entity.Org;
import com.pengh.usermg.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author PENGHUI
 * @date create on 2019/3/27
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrgServiceImpl implements OrgService {

    @Override
    public Integer save(Org org) {
        return orgMapper.insert(org);
    }

    @Override
    public void update(Org org) {
        orgMapper.updateByPrimaryKey(org);
    }

    @Override
    public void delete(Long id) {
        orgMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Org> list(String orgName) {
        return orgMapper.selectAll(orgName);
    }

    @Autowired
    private OrgMapper orgMapper;

}
