package com.zeze.demo.cache.mapper;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Field;

public class SubscriberMapper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4421105161855987308L;

	@Id
	private String topicName;		//主题名
	@Field
	private String parentTopic;		//父 主题名
	@Field
	private List<String> childTopic;  //子 主题名 
	@Field
	private List<String> publishIds;  //相关该主题发布的消息列表
	@Field
	private List<SubClient> subscribers; //订阅该主题的用户列表
	
	
	public String getParentTopic() {
		return parentTopic;
	}

	public void setParentTopic(String parentTopic) {
		this.parentTopic = parentTopic;
	}

	public List<String> getChildTopic() {
		return childTopic;
	}

	public void setChildTopic(List<String> childTopic) {
		this.childTopic = childTopic;
	}

	public List<String> getPublishIds() {
		return publishIds;
	}

	public void setPublishIds(List<String> publishIds) {
		this.publishIds = publishIds;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public List<SubClient> getSubscribers() {
		return subscribers;
	}

	public void setSubscribers(List<SubClient> subscribers) {
		this.subscribers = subscribers;
	}

	
}
