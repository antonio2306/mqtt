package com.zeze.demo.cache.mapper;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Field;

public class PublishedMessageMapper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4533105534954190463L;

	@Id
	private String publishId; //publisher's clientid + messageid  发布标志
	@Field
	private String topicName;	//所发布消息的主题名称
	@Field
	private byte[] message;		//发布的消息
	@Field
	private Integer pubQos;		
	@Field
	private String publisherId;

	public String getPublishId() {
		return publishId;
	}
	public void setPublishId(String publishId) {
		this.publishId = publishId;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public byte[] getMessage() {
		return message;
	}
	public void setMessage(byte[] message) {
		this.message = message;
	}
	public Integer getPubQos() {
		return pubQos;
	}
	public void setPubQos(Integer pubQos) {
		this.pubQos = pubQos;
	}
	public String getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}
	
	
}
