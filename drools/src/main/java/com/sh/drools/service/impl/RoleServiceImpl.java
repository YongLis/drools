package com.sh.drools.service.impl;

import com.sh.drools.dal.mapper.RoleMapper;
import com.sh.drools.dal.model.Role;
import com.sh.drools.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

/**
 * @Auther: liyong
 * @Date:2019/6/19 10:26
 * @Desc: the description of class
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired(required = false)
    private RoleMapper roleMapper;

    @Override
    public List<Role> findByStatus(boolean b) {
        return roleMapper.findByStatus(b);
    }

    @Override
    public Role findOne(int id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }

    @Override
    public Object save(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public void delete(int id) {
        roleMapper.deleteByPrimaryKey(id);
    }
}
