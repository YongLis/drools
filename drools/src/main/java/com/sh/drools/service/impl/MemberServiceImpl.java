package com.sh.drools.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sh.drools.common.PageQueryRequest;
import com.sh.drools.common.PagedResult;
import com.sh.drools.dal.mapper.MemberMapper;
import com.sh.drools.dal.mapper.MemberRoleMapper;
import com.sh.drools.dal.model.Member;
import com.sh.drools.dal.model.MemberRole;
import com.sh.drools.dal.model.Role;
import com.sh.drools.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: liyong
 * @Date:2019/6/19 10:25
 * @Desc: the description of class
 */
@Service("memberService")
public class MemberServiceImpl implements MemberService {
    @Autowired(required = false)
    private MemberMapper memberMapper;
    @Autowired(required = false)
    private MemberRoleMapper memberRoleMapper;

    @Override
    public int countByUserName(String userName) {
        return memberMapper.countByUserName(userName);
    }

    @Override
    public Member findByUserName(String userName) {
        return memberMapper.findByUserName(userName);
    }

    @Override
    public Member findOne(Integer id) {
        return memberMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Member> pageQuery(PageQueryRequest<Member> request) {
        PageHelper.startPage(request.getPageNumber(), request.getPageSize());
        List<Member> list = memberMapper.selectByCondition(request.getT());
        return new PageInfo<>(list);
    }

    @Override
    public void save(Member member) {
        memberMapper.insert(member);
    }

    @Override
    public void delete(Integer id) {
        memberMapper.deleteByPrimaryKey(id);
    }
}
