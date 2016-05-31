package com.zeze.demo.cache.mapper;

import java.io.Serializable;

import io.netty.handler.codec.mqtt.MqttMessageType;

public class ChannelStatusMapper implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private volatile MqttMessageType status = MqttMessageType.PUBLISH;

	public MqttMessageType getStatus() {
		return status;
	}

	public void setStatus(MqttMessageType status) {
		this.status = status;
	}
	
}
