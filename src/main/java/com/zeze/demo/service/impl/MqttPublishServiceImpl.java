package com.zeze.demo.service.impl;


import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.netty.channel.Channel;
import io.netty.channel.ChannelId;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttQoS;

import com.zeze.demo.cache.mapper.ClientMapper;
import com.zeze.demo.mqtt.MqttServerHandler;
import com.zeze.demo.mqtt.MqttStaticUtil;
import com.zeze.demo.service.MqttPublishService;

public class MqttPublishServiceImpl implements MqttPublishService {

	private ExecutorService executor = Executors.newCachedThreadPool();
	
	@Override
	public String recvMsg(String clientId, Object msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sendMsg(String clientId, Object msg) {
		
		ClientMapper clientMapper = (ClientMapper) MqttStaticUtil.nativeCache.get(clientId);
		ChannelId cid = clientMapper.getChannelId();
		Channel ch = MqttServerHandler.channelGroup.find(cid);
		ch.writeAndFlush(msg);
		
		return null;
	}

	@Override
	public String publishMsg(MqttPublishMessage mqttPublishMessage,
			MqttQoS publishQos) {
		
		String topicName = mqttPublishMessage.variableHeader().topicName();
		List<String> clientIds;
		switch (publishQos) {
		case AT_MOST_ONCE:
			clientIds = MqttStaticUtil.topicSubsribers
				.get(topicName).get(MqttQoS.AT_LEAST_ONCE.value());
			for (String clientId : clientIds) {
				executor.execute(new SendTask(clientId, mqttPublishMessage));
			}
			break;
		case AT_LEAST_ONCE:
			
			break;
		case EXACTLY_ONCE:
			break;
		default:
			break;
		}
		return null;
	}
	
	@Override
	public String publishMsgAtMostOnce(MqttPublishMessage mqttPublishMessage, List<String> clientIds) {
		
		for (String clientId : clientIds) {
			//开启发送线程！
			executor.execute(new SendTask(clientId, mqttPublishMessage));
			MqttStaticUtil.nativeCache.remove(clientId);
		}
		
		return null;
	}

	@Override
	public String publishMsgAtleastOnce(MqttPublishMessage mqttPublishMessage, List<String> clientIds) {
		
		for (String clientId : clientIds) {
			//开启发送线程！
			Timer timer = new Timer();
			timer.schedule(new SendTimerTask(clientId, mqttPublishMessage), 0, 3000);
		}
		return null;
	}

	@Override
	public String publishMsgExactlyOnce(MqttPublishMessage mqttPublishMessage, List<String> clientIds) {
		// TODO Auto-generated method stub
		return null;
	}
	
	class SendTask implements Runnable {

		private String clientId;
		private Object msg;
		
		public SendTask(String clientId, Object msg) {
			this.clientId = clientId;
			this.msg = msg;
		}
		
		@Override
		public void run() {
			sendMsg(clientId, msg);
		}
	}
	
	class SendTimerTask extends TimerTask {

		private String clientId;
		private Object msg;
		
		public SendTimerTask(String clientId, Object msg) {
			this.clientId = clientId;
			this.msg = msg;
		}
		
		@Override
		public void run() {
			sendMsg(clientId, msg);
		}
	}

}
