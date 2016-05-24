package com.zeze.demo.entity;

import io.netty.handler.codec.mqtt.MqttPublishMessage;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TopicMessageEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, MqttPublishMessage> topicMessage = new ConcurrentHashMap<String, MqttPublishMessage>();
	
	public Map<String, MqttPublishMessage> getTopicMessage() {
		return topicMessage;
	}

	public void setTopicMessage(Map<String, MqttPublishMessage> topicMessage) {
		this.topicMessage = topicMessage;
	}

	public TopicMessageEntity put(String topicName, MqttPublishMessage mqttPublishMessage) {
		topicMessage.put(topicName, mqttPublishMessage);
		return this;
	}
	
	public MqttPublishMessage get(String topicName) {
		MqttPublishMessage mqttPublishMessage = topicMessage.get(topicName);
		return mqttPublishMessage;
	}
	
	public TopicMessageEntity remove(String topicName) {
		topicMessage.remove(topicName);
		return this;
	}
	
	public TopicMessageEntity clear() {
		topicMessage.clear();
		return this;
	}

}
