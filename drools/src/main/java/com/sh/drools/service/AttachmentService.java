package com.sh.drools.service;

import com.sh.drools.common.AttachmentType;
import com.sh.drools.dal.model.Attachment;
import com.sh.drools.dal.model.Member;

import java.util.List;


public interface AttachmentService {
    
    Attachment findByFilePath(String filePath);

    List<Attachment> findByFilePathIsNotAndMemberAndType(String filePath, Member member, AttachmentType type);

    void clearAvatar(Member smember);
}
