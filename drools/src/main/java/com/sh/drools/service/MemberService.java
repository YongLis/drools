package com.sh.drools.service;


import com.github.pagehelper.PageInfo;
import com.sh.drools.common.PageQueryRequest;
import com.sh.drools.common.PageQueryResponse;
import com.sh.drools.common.PagedResult;
import com.sh.drools.dal.model.Member;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;

public interface MemberService {

    int countByUserName(String userName);

    Member findByUserName(String userName);

    Member findOne(Integer id);

    PageInfo<Member> pageQuery(PageQueryRequest<Member> request);

    void save(Member member);

    void delete(Integer id);
}
