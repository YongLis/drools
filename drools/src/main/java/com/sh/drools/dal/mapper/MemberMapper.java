package com.sh.drools.dal.mapper;

import com.sh.drools.dal.model.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface MemberMapper {

	public List<Member> findAll();
}
