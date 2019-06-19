package com.sh.drools.dal.mapper;

import com.sh.drools.dal.model.Resource;

import java.util.List;

public interface ResourceMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(Resource record);
    int insertSelective(Resource record);
    Resource selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);

    Iterable<Resource> findByParentIsNull();

    Iterable<Resource> findByStatusAndParentIsNull(int status);

    Iterable<Resource> findByParent(Resource t);

    Iterable<Resource> findByStatusAndParent(int status, Resource t);

    List<Resource> findAll();
}