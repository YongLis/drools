package com.sh.drools.service.impl;

import com.sh.drools.common.AttachmentType;
import com.sh.drools.dal.model.Attachment;
import com.sh.drools.dal.model.Member;
import com.sh.drools.service.AttachmentService;

import java.util.List;

/**
 * @Auther: liyong
 * @Date:2019/6/19 10:24
 * @Desc: the description of class
 */
public class AttachmentServiceImpl implements AttachmentService {
    @Override
    public Attachment findByFilePath(String filePath) {
        return null;
    }

    @Override
    public List<Attachment> findByFilePathIsNotAndMemberAndType(String filePath, Member member, AttachmentType type) {
        return null;
    }
}
