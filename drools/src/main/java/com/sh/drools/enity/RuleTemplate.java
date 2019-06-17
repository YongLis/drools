package com.sh.drools.enity;

import org.apache.commons.lang3.StringUtils;

public class RuleTemplate {
	public static String RULE_PACKAGE = "com.template";
	public static String RULE_IMPORT = "#{rule.import}";
	public static String RULE_ID = "#{rule.id}";
	public static String RULE_CONDITION = "#{rule.rule.condition}";
	public static String RULE_ACTION = "#{rule.action}";
	
	public static String getRuleTemplate(){
	
		StringBuilder builder = new StringBuilder();
		builder.append("package ").append(RULE_PACKAGE)
				.append("\r\n")
				.append("no-loop true")
				.append("\r\n")
				.append(RULE_IMPORT)
				.append("\r\n")
				.append("rule \""+RULE_ID+"\"")
				.append("\r\n")
				.append("when")
				.append("\r\n")
				.append(RULE_CONDITION)
				.append("\r\n")
				.append("then")
				.append("\r\n")
				.append(RULE_ACTION)
				.append("\r\n")
				.append("end");
		
		return builder.toString();
	}

}
