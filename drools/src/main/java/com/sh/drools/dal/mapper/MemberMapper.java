package com.sh.drools.dal.mapper;

import com.sh.drools.dal.model.Member;

import java.util.List;

public interface MemberMapper {

    int deleteByPrimaryKey(Integer id);
    int insert(Member record);
    int insertSelective(Member record);
    Member selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Member record);
    int updateByPrimaryKey(Member record);

    int countByUserName(String userName);
    Member findByUserName(String userName);

    List<Member> selectByCondition(Member member);

}