package com.zeze.demo.cache.mapper;

public class SubClient {
	
	private String clientId;
	private Integer messageId;
	private Integer subQos;
	
	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public Integer getSubQos() {
		return subQos;
	}
	public void setSubQos(Integer subQos) {
		this.subQos = subQos;
	}
	
}

