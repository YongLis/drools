package com.sh.drools.dal.model;

public class RuleInfoWithBLOBs extends RuleInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rule_info.rule_import
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    private String ruleImport;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rule_info.rule_action
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    private String ruleAction;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rule_info.rule_import
     *
     * @return the value of rule_info.rule_import
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    public String getRuleImport() {
        return ruleImport;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rule_info.rule_import
     *
     * @param ruleImport the value for rule_info.rule_import
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    public void setRuleImport(String ruleImport) {
        this.ruleImport = ruleImport == null ? null : ruleImport.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rule_info.rule_action
     *
     * @return the value of rule_info.rule_action
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    public String getRuleAction() {
        return ruleAction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rule_info.rule_action
     *
     * @param ruleAction the value for rule_info.rule_action
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    public void setRuleAction(String ruleAction) {
        this.ruleAction = ruleAction == null ? null : ruleAction.trim();
    }
}