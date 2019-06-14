package com.sh.drools.service.impl;

import com.sh.drools.enity.RuleInfo;
import com.sh.drools.enity.RuleTemplate;
import com.sh.drools.service.KieSessionService;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderError;
import org.kie.internal.builder.KnowledgeBuilderErrors;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;

import java.util.ArrayList;
import java.util.List;

public class KieSessionServiceImpl implements KieSessionService {

	private KnowledgeBuilder knowledgeBuilder = null;

	@SuppressWarnings("deprecation")
	public KieSession getStatefulKnowledgeSession() throws Exception {

		KnowledgeBuilderErrors errors = knowledgeBuilder.getErrors();
		for (KnowledgeBuilderError error : errors) {
			System.out.println(error);
		}

		KnowledgeBase base = KnowledgeBaseFactory.newKnowledgeBase();
		base.addKnowledgePackages(knowledgeBuilder.getKnowledgePackages());

		return base.newStatefulKnowledgeSession();
	}

	@SuppressWarnings("deprecation")
	public KieSession getStatelessKnowledgeSession() throws Exception {
		
		KnowledgeBuilderErrors errors = knowledgeBuilder.getErrors();
		for (KnowledgeBuilderError error : errors) {
			System.out.println(error);
		}

		KnowledgeBase base = KnowledgeBaseFactory.newKnowledgeBase();
		base.addKnowledgePackages(knowledgeBuilder.getKnowledgePackages());

		return (KieSession) base.newStatelessKnowledgeSession();
	}

	private void loadRule(List<RuleInfo> ruleList) throws Exception {
		if (ruleList != null && ruleList.size() > 0) {
			for (RuleInfo ruleInfo : ruleList) {
				knowledgeBuilder.add(ResourceFactory
						.newByteArrayResource(RuleTemplate.getRule(ruleInfo)
								.getBytes("UTF-8")), ResourceType.DRL);
			}
		}

	}

	public void updateRule(List<RuleInfo> ruleList) throws Exception {
		removeRule(ruleList);
		loadRule(ruleList);
	}

	@SuppressWarnings("deprecation")
	public void removeRule(List<RuleInfo> ruleList) throws Exception {
		if (ruleList != null && ruleList.size() > 0) {
			for (RuleInfo ruleInfo : ruleList) {
				knowledgeBuilder.newKnowledgeBase().removeRule(RuleTemplate.RULE_PACKAGE, ruleInfo.getRuleId());
			}
		}
	}

	public void init() throws Exception {
		knowledgeBuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();
		List<RuleInfo> ruleList = new ArrayList<RuleInfo>();
		
		RuleInfo ruleInfo = new RuleInfo();
		ruleInfo.setRuleId("rule01");
		ruleInfo.setRuleCondition("body.age>65");
		ruleInfo.setRuleAction("System.out.println(\"rule01执行\")");
		ruleList.add(ruleInfo);
		loadRule(ruleList);
	}

}
