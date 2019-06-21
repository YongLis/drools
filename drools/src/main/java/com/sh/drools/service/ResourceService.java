package com.sh.drools.service;

import com.sh.drools.dal.model.Resource;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;
import java.util.List;

public interface ResourceService{
    Iterable<Resource> getResourceTree(Boolean status);

    Iterable<Resource> getResourceTree();

    List<Resource> findAll();

    Resource findOne(int id);

    Object save(Resource resource);

    void delete(int id);

    List<Resource> findByStatus(boolean b);
}
