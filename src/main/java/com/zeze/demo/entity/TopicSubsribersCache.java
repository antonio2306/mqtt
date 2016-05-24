package com.zeze.demo.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TopicSubsribersCache implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Map<String, List<String>> topicSubsribers = new ConcurrentHashMap<String, List<String>>();

	public Map<String, List<String>> getTopicSubsribers() {
		return topicSubsribers;
	}

	public void setTopicSubsribers(Map<String, List<String>> topicSubsribers) {
		this.topicSubsribers = topicSubsribers;
	}
	
	public TopicSubsribersCache put(String topicName, LinkedList<String> subsribers) {
		this.topicSubsribers.put(topicName, subsribers);
		return this;
	}
	
	public List<String> get(String topicName) {
		return this.topicSubsribers.get(topicName);
	}
	
	public TopicSubsribersCache remove(String topicName) {
		this.topicSubsribers.remove(topicName);
		return this;
	}
	
	public TopicSubsribersCache clear() {
		this.topicSubsribers.clear();
		return this;
	}
	
}
