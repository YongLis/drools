package com.sh.drools.service.impl;

import com.sh.drools.common.RuleStateEnum;
import com.sh.drools.dal.model.RuleInfoWithBLOBs;
import com.sh.drools.enity.RuleTemplate;
import com.sh.drools.service.KieSessionService;
import com.sh.drools.service.RuleInfoService;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderError;
import org.kie.internal.builder.KnowledgeBuilderErrors;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("kieSessionService")
public class KieSessionServiceImpl implements KieSessionService {
	private KnowledgeBuilder knowledgeBuilder = null;
	@Autowired
	private RuleInfoService ruleInfoService;

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

	private void loadRule(List<RuleInfoWithBLOBs> ruleList) throws Exception {
//		List<RuleInfoWithBLOBs> ruleList = ruleInfoService.findByStatus(RuleStateEnum.WAIT.getCode());
		if (ruleList != null && ruleList.size() > 0) {
			for (RuleInfoWithBLOBs ruleInfo : ruleList) {
				knowledgeBuilder.add(ResourceFactory
						.newByteArrayResource(ruleInfoService.parseRule(ruleInfo)
								.getBytes("UTF-8")), ResourceType.DRL);
			}
		}

	}

	public void updateRule(List<RuleInfoWithBLOBs> ruleList) throws Exception {
		removeRule(ruleList);
		loadRule(ruleList);
	}

	@SuppressWarnings("deprecation")
	public void removeRule(List<RuleInfoWithBLOBs> ruleList) throws Exception {
		if (ruleList != null && ruleList.size() > 0) {
			for (RuleInfoWithBLOBs ruleInfo : ruleList) {
				knowledgeBuilder.newKnowledgeBase().removeRule(RuleTemplate.RULE_PACKAGE, ruleInfo.getRuleId());
			}
		}
	}

	public void init() throws Exception {
		knowledgeBuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();
		List<RuleInfoWithBLOBs> ruleList = ruleInfoService.findByStatus(RuleStateEnum.WAIT.getCode());
		loadRule(ruleList);
	}

}
