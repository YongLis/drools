package com.sh.drools.dal.mapper;

import com.sh.drools.dal.model.MemberRole;

public interface MemberRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_member_role
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_member_role
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    int insert(MemberRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_member_role
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    int insertSelective(MemberRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_member_role
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    MemberRole selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_member_role
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    int updateByPrimaryKeySelective(MemberRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_member_role
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    int updateByPrimaryKey(MemberRole record);
}