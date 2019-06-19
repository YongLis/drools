package com.sh.drools.dal.crm;

import com.sh.drools.common.AttachmentType;
import com.sh.drools.dal.model.Attachment;
import com.sh.drools.dal.model.Member;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AttachmentDao extends PagingAndSortingRepository<Attachment, Long> {
    
    Attachment findByFilePath(String filePath);

    List<Attachment> findByFilePathIsNotAndMemberAndType(String filePath, Member member, AttachmentType type);

}
