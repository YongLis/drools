package com.sh.drools.service;

import com.sh.drools.dal.model.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleService extends PagingAndSortingRepository<Role, Long> {

    List<Role> findByStatus(boolean b);
}
