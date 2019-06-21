package com.sh.drools.service.impl;

import com.sh.drools.dal.mapper.ResourceMapper;
import com.sh.drools.dal.model.Resource;
import com.sh.drools.service.ResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: liyong
 * @Date:2019/6/18 17:13
 * @Desc: the description of class
 */
@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {
    Logger logger = LoggerFactory.getLogger(ResourceServiceImpl.class);

    @Autowired(required = false)
    ResourceMapper resourceMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterable<Resource> getResourceTree(Boolean status) {
        Iterable<Resource> root;
        if (status == null) {
            root = resourceMapper.findByParentIsNull();
        } else {
            root = resourceMapper.findByStatusAndParentIsNull(status ? 1 : 0);
        }
        this.buildTree(root, status);
        return root;
    }

    /**
     * {@inheritDoc}
     *
     */
    @Override
    public Iterable<Resource> getResourceTree() {
        return this.getResourceTree(null);
    }

    @Override
    public List<Resource> findAll() {
        return resourceMapper.findAll();
    }

    @Override
    public Resource findOne(int id) {
        return resourceMapper.selectByPrimaryKey(id);
    }

    @Override
    public Object save(Resource resource) {
        return resourceMapper.insert(resource);
    }

    @Override
    public void delete(int id) {
        resourceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Resource> findByStatus(boolean b) {
        return resourceMapper.findAll();
    }

    private void buildTree(Iterable<Resource> root, Boolean status) {
        root.forEach(t -> {
            Iterable<Resource> children;

            if (status == null) {
                children = resourceMapper.findByParent(t);
            } else {
                children = resourceMapper.findByStatusAndParent(status ? 1 : 0, t);
            }

            children.forEach(c -> t.getChildren().add(c));

            // 此处递归
            buildTree(children, status);
        });
    }
}
