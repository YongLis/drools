package com.sh.drools.service.impl;

import com.sh.drools.common.RuleStateEnum;
import com.sh.drools.dal.mapper.RuleInfoMapper;
import com.sh.drools.dal.model.RuleInfoWithBLOBs;
import com.sh.drools.enity.RuleTemplate;
import com.sh.drools.service.RuleInfoService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: liyong
 * @Date:2019/6/17 11:43
 * @Desc: the description of class
 */
@Service("ruleInfoService")
public class RuleInfoServiceImpl implements RuleInfoService {
    private static Logger logger = LoggerFactory.getLogger(RuleInfoServiceImpl.class);
    @Autowired(required = false)
    private RuleInfoMapper ruleInfoMapper;

    @Override
    public void addRule(RuleInfoWithBLOBs ruleInfo) throws Exception {
        ruleInfoMapper.insert(ruleInfo);
    }

    @Override
    public void updateRule(RuleInfoWithBLOBs ruleInfo) throws Exception {
        ruleInfoMapper.updateByPrimaryKey(ruleInfo);
    }

    @Override
    public void deadRule(String ruleId) throws Exception {
        RuleInfoWithBLOBs ruleInfoWithBLOBs = findByRuleId(ruleId);
        ruleInfoWithBLOBs.setStatus(RuleStateEnum.UN_ACTIVE.getCode());
        ruleInfoMapper.updateByPrimaryKey(ruleInfoWithBLOBs);
    }

    @Override
    public String parseRule(String ruleId) throws Exception {
        RuleInfoWithBLOBs ruleInfo = findByRuleId(ruleId);
        String result = null;
        if(ruleInfo != null){
            String ruleTemplate = RuleTemplate.getRuleTemplate();
            if(StringUtils.isEmpty(ruleInfo.getRuleImport())){
                ruleInfo.setRuleImport("");
            }

            if(StringUtils.isEmpty(ruleInfo.getRuleCondition())){
                ruleInfo.setRuleCondition("");;
            }

            if(StringUtils.isEmpty(ruleInfo.getRuleAction())){
                ruleInfo.setRuleAction("");;
            }

            String rule1 = ruleTemplate.replace(RuleTemplate.RULE_IMPORT, ruleInfo.getRuleImport());
            String rule2 = rule1.replace(RuleTemplate.RULE_ID, ruleInfo.getRuleId());
            String rule3 = rule2.replace(RuleTemplate.RULE_CONDITION, ruleInfo.getRuleCondition());
            result = rule3.replace(RuleTemplate.RULE_ACTION, ruleInfo.getRuleAction());
        }
        return result;
    }

    @Override
    public RuleInfoWithBLOBs findByRuleId(String ruleId) {
        return ruleInfoMapper.selectByPrimaryKey(ruleId);
    }

    @Override
    public List<RuleInfoWithBLOBs> findByStatus(String status) {
        return ruleInfoMapper.selectByStatus(status);
    }
}
