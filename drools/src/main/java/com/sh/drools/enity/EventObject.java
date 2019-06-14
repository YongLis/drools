package com.sh.drools.enity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class EventObject implements Serializable{
	private static final long serialVersionUID = 1L;
	private HashMap<String, Object> body = new HashMap<String, Object>();
	private String ruleName;
	private String uuid;
	private String host;
	private String channel;
	private String status;
	private String retCode;
	private String retMsg;
	
	public void addAll(Map<String, Object> map){
		this.body.putAll(map);
	}
	
	public void putBody(String key, Object object){
		this.body.put(key, object);
	}
	
	public Object getBodyValue(String key){
		return this.body.get(key);
	}
	
	public String getRuleName() {
		return ruleName;
	}


	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}


	public String getUuid() {
		return uuid;
	}


	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	public String getHost() {
		return host;
	}


	public void setHost(String host) {
		this.host = host;
	}


	public String getChannel() {
		return channel;
	}


	public void setChannel(String channel) {
		this.channel = channel;
	}


	public HashMap<String, Object> getBody() {
		return body;
	}
	public void setBody(HashMap<String, Object> body) {
		this.body = body;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRetCode() {
		return retCode;
	}
	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}
	public String getRetMsg() {
		return retMsg;
	}
	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

}
