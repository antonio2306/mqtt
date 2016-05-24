package com.zeze.demo.service;


import io.netty.channel.ChannelId;



public interface SendMessageService {

	String recvMsg(ChannelId id, Object msg);
	String saveChannelId(String did, ChannelId id);
	
}
