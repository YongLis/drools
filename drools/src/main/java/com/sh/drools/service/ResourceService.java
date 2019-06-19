package com.sh.drools.service;

import com.sh.drools.dal.model.Resource;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ResourceService{
    Iterable<Resource> getResourceTree(Boolean status);

    Iterable<Resource> getResourceTree();
}
