package com.zeze.demo.cache.mapper;

import io.netty.channel.ChannelId;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Field;

public class ClientMapper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2927440133013917631L;

	@Id
	private String clientId;	//终端标识符 
	
	@Field
	private ChannelId channelId;	 //会话信息
	@Field
	private List<SubMessage> subMessages; //订阅相关主题推送的消息列表
	@Field
	private List<SubTopics> subTopics;	//订阅主题列表
	@Field
	private List<String> publishIds;	//该用户发布的消息列表
	@Field
	private Integer keepAliveTimeSeconds; //会话保活时间
	
	
	public Integer getKeepAliveTimeSeconds() {
		return keepAliveTimeSeconds;
	}
	public void setKeepAliveTimeSeconds(Integer keepAliveTimeSeconds) {
		this.keepAliveTimeSeconds = keepAliveTimeSeconds;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public ChannelId getChannelId() {
		return channelId;
	}
	public void setChannelId(ChannelId channelId) {
		this.channelId = channelId;
	}
	public List<SubMessage> getSubMessages() {
		return subMessages;
	}
	public void setSubMessages(List<SubMessage> subMessages) {
		this.subMessages = subMessages;
	}
	public List<String> getPublishIds() {
		return publishIds;
	}
	public void setPublishIds(List<String> publishIds) {
		this.publishIds = publishIds;
	}

}
