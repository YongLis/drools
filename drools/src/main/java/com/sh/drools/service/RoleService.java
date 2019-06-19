package com.sh.drools.service;

import com.sh.drools.dal.model.Role;
import java.util.List;
public interface RoleService{
    List<Role> findByStatus(boolean b);

    Role findOne(int id);

    List<Role> findAll();

    Object save(Role role);

    void delete(int id);
}
