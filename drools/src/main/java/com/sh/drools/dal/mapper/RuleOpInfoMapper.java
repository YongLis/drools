package com.sh.drools.dal.mapper;

import com.sh.drools.dal.model.RuleOpInfo;

public interface RuleOpInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rule_op_info
     *
     * @mbggenerated Tue Jun 18 15:54:20 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rule_op_info
     *
     * @mbggenerated Tue Jun 18 15:54:20 CST 2019
     */
    int insert(RuleOpInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rule_op_info
     *
     * @mbggenerated Tue Jun 18 15:54:20 CST 2019
     */
    int insertSelective(RuleOpInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rule_op_info
     *
     * @mbggenerated Tue Jun 18 15:54:20 CST 2019
     */
    RuleOpInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rule_op_info
     *
     * @mbggenerated Tue Jun 18 15:54:20 CST 2019
     */
    int updateByPrimaryKeySelective(RuleOpInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rule_op_info
     *
     * @mbggenerated Tue Jun 18 15:54:20 CST 2019
     */
    int updateByPrimaryKey(RuleOpInfo record);
}