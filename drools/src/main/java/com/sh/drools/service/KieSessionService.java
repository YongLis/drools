package com.sh.drools.service;

import com.sh.drools.enity.RuleInfo;
import org.kie.api.runtime.KieSession;

import java.util.List;

/**
 * @Auther: liyong
 * @Date:2019/6/14 18:07
 * @Desc: the description of class
 */
public interface KieSessionService {

    /**
     * 初始化
     */
    public void init() throws Exception;

    /**
     * 获取有状态的StatefulKnowledgeSession
     */

    public KieSession getStatefulKnowledgeSession() throws Exception;
    /**
     * 获取无状态的StatelessKnowledgeSession
     */

    public KieSession getStatelessKnowledgeSession() throws Exception;


    /**
     * 更新规则
     */

    public void updateRule(List<RuleInfo> ruleList) throws Exception;

    /**
     * 移除规则
     */

    public void removeRule(List<RuleInfo> ruleList) throws Exception;
}
