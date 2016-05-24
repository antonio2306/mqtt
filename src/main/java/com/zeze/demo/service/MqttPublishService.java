package com.zeze.demo.service;

import java.util.List;

import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttQoS;

public interface MqttPublishService {

	//接受特定会话的消息
	public String recvMsg(String clientId, Object msg);
	
	//发送消息至特定会话
	public String sendMsg(String clientId, Object msg);
	
	//广播消息
	public String publishMsgAtMostOnce(MqttPublishMessage mqttPublishMessage, List<String> clientIds);
	
	public String publishMsgAtleastOnce(MqttPublishMessage mqttPublishMessage, List<String> clientIds);
	
	public String publishMsgExactlyOnce(MqttPublishMessage mqttPublishMessage, List<String> clientIds);
	
	public String publishMsg(MqttPublishMessage mqttPublishMessage, MqttQoS publishQos);
}
