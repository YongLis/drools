package com.sh.drools.service.impl;

import com.sh.drools.dal.crm.ResourceDao;
import com.sh.drools.dal.model.Resource;
import com.sh.drools.service.ResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: liyong
 * @Date:2019/6/18 17:13
 * @Desc: the description of class
 */
@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {
    Logger logger = LoggerFactory.getLogger(ResourceServiceImpl.class);

    @Autowired
    ResourceDao resourceDao;

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterable<Resource> getResourceTree(Boolean status) {
        Iterable<Resource> root;
        if (status == null) {
            root = resourceDao.findByParentIsNull();
        } else {
            root = resourceDao.findByStatusAndParentIsNull(status, ResourceDao.WEIGHT_SORT);
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

    private void buildTree(Iterable<Resource> root, Boolean status) {
        root.forEach(t -> {
            Iterable<Resource> children;

            if (status == null) {
                children = resourceDao.findByParent(t, ResourceDao.WEIGHT_SORT);
            } else {
                children = resourceDao.findByStatusAndParent(status, t, ResourceDao.WEIGHT_SORT);
            }

            children.forEach(c -> t.getChildren().add(c));

            // 此处递归
            buildTree(children, status);
        });
    }
}
