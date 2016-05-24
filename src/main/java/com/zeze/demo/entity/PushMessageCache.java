package com.zeze.demo.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PushMessageCache implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * key: clientid + msgid
	 */
	private Map<String, List<TopicMessageEntity>> pushMessage = new ConcurrentHashMap<String, List<TopicMessageEntity>>();

	
	public Map<String, List<TopicMessageEntity>> getPushMessage() {
		return pushMessage;
	}


	public void setPushMessage(Map<String, List<TopicMessageEntity>> pushMessage) {
		this.pushMessage = pushMessage;
	}
	
	public PushMessageCache put(String id, LinkedList<TopicMessageEntity> topicMessages) {
		
		pushMessage.put(id, topicMessages);
		return this;
	}
	
	public List<TopicMessageEntity> get(String id) {
		
		return pushMessage.get(id);
	}
	
	public PushMessageCache remove(String id) {
		
		pushMessage.remove(id);
		return this;
	}
	
	public PushMessageCache clear() {
		
		pushMessage.clear();
		return this;
	}
	
}
