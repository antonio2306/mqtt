package com.zeze.demo.cache.mapper;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Document
public class MqttClientMapper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	private String clientId;
	@Field
	private String userName;
	@Field
	private String willTopic;
	@Field
	private String willMsg;
	@Field
	private Integer willQos;
	@Field
	private String cleanSession;
	@Field
	private String publishQos;
	@Field
	private Integer keepAliveTimeSeconds;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getWillMsg() {
		return willMsg;
	}
	public void setWillMsg(String willMsg) {
		this.willMsg = willMsg;
	}
	public Integer getWillQos() {
		return willQos;
	}
	public void setWillQos(Integer willQos) {
		this.willQos = willQos;
	}
	public String getCleanSession() {
		return cleanSession;
	}
	public void setCleanSession(String cleanSession) {
		this.cleanSession = cleanSession;
	}
	public String getPublishQos() {
		return publishQos;
	}
	public void setPublishQos(String publishQos) {
		this.publishQos = publishQos;
	}
	public Integer getKeepAliveTimeSeconds() {
		return keepAliveTimeSeconds;
	}
	public void setKeepAliveTimeSeconds(Integer keepAliveTimeSeconds) {
		this.keepAliveTimeSeconds = keepAliveTimeSeconds;
	}
	public String getWillTopic() {
		return willTopic;
	}
	public void setWillTopic(String willTopic) {
		this.willTopic = willTopic;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	
}
