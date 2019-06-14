package com.sh.drools.common;

public enum RuleStateEnum {
	ACTIVE("1", "使用中"),
	UN_ACTIVE("2", "停用"),
	WAIT("0", "待启用");
	
	private String code;
	private String desc;
	RuleStateEnum(String code, String desc){
		this.code = code;
		this.desc = desc;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

}
