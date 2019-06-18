package com.sh.drools.dal.model;

import java.util.Date;

public class RuleOpInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rule_op_info.id
     *
     * @mbggenerated Tue Jun 18 15:54:20 CST 2019
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rule_op_info.rule_id
     *
     * @mbggenerated Tue Jun 18 15:54:20 CST 2019
     */
    private String ruleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rule_op_info.operate
     *
     * @mbggenerated Tue Jun 18 15:54:20 CST 2019
     */
    private String operate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rule_op_info.status
     *
     * @mbggenerated Tue Jun 18 15:54:20 CST 2019
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rule_op_info.create_time
     *
     * @mbggenerated Tue Jun 18 15:54:20 CST 2019
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rule_op_info.id
     *
     * @return the value of rule_op_info.id
     *
     * @mbggenerated Tue Jun 18 15:54:20 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rule_op_info.id
     *
     * @param id the value for rule_op_info.id
     *
     * @mbggenerated Tue Jun 18 15:54:20 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rule_op_info.rule_id
     *
     * @return the value of rule_op_info.rule_id
     *
     * @mbggenerated Tue Jun 18 15:54:20 CST 2019
     */
    public String getRuleId() {
        return ruleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rule_op_info.rule_id
     *
     * @param ruleId the value for rule_op_info.rule_id
     *
     * @mbggenerated Tue Jun 18 15:54:20 CST 2019
     */
    public void setRuleId(String ruleId) {
        this.ruleId = ruleId == null ? null : ruleId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rule_op_info.operate
     *
     * @return the value of rule_op_info.operate
     *
     * @mbggenerated Tue Jun 18 15:54:20 CST 2019
     */
    public String getOperate() {
        return operate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rule_op_info.operate
     *
     * @param operate the value for rule_op_info.operate
     *
     * @mbggenerated Tue Jun 18 15:54:20 CST 2019
     */
    public void setOperate(String operate) {
        this.operate = operate == null ? null : operate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rule_op_info.status
     *
     * @return the value of rule_op_info.status
     *
     * @mbggenerated Tue Jun 18 15:54:20 CST 2019
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rule_op_info.status
     *
     * @param status the value for rule_op_info.status
     *
     * @mbggenerated Tue Jun 18 15:54:20 CST 2019
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rule_op_info.create_time
     *
     * @return the value of rule_op_info.create_time
     *
     * @mbggenerated Tue Jun 18 15:54:20 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rule_op_info.create_time
     *
     * @param createTime the value for rule_op_info.create_time
     *
     * @mbggenerated Tue Jun 18 15:54:20 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}