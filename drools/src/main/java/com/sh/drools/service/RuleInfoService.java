package com.sh.drools.service;

import com.sh.drools.dal.model.RuleInfoWithBLOBs;

import java.util.List;

/**
 * @Auther: liyong
 * @Date:2019/6/17 11:37
 * @Desc: the description of class
 */
public interface RuleInfoService {
    // 添加规则
    public void addRule(RuleInfoWithBLOBs ruleInfo) throws Exception;

    // 修改规则
    public void updateRule(RuleInfoWithBLOBs ruleInfo)throws Exception;

    // 停用规则
    public void deadRule(String ruleId) throws Exception;

    // 规则解析
    public String parseRule(String ruleId) throws Exception;

    public RuleInfoWithBLOBs findByRuleId(String ruleId);

    public List<RuleInfoWithBLOBs> findByStatus(String status);
}
