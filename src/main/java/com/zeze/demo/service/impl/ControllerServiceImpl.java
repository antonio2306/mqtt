package com.zeze.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelId;


import com.zeze.demo.cache.mapper.ChannelidMapper;
import com.zeze.demo.cache.repository.ChannelidRepository;
import com.zeze.demo.netty.ChannelMap;
import com.zeze.demo.netty.TimeServerHandler;
import com.zeze.demo.service.ContollerService;

@Service
public class ControllerServiceImpl implements ContollerService {

	@Autowired
	ChannelidRepository channelidDao;
	
	@Override
	public String sendMsg(Object msg) {

//		ChannelidMapper channelidMapper = channelidDao.findOne("0007");	
//		if (channelidMapper != null)	{
//			
//			Channel ch = TimeServerHandler.channelGroup.find(channelidMapper.getChannelid());
//			ByteBuf buff = ch.alloc().buffer();
//			buff.writeBytes(((String) msg).getBytes());
//			ch.writeAndFlush(buff);
//		}
		ChannelId id = ChannelMap.get("0007");
		Channel ch = TimeServerHandler.channelGroup.find(id);
		
		ByteBuf buff = ch.alloc().buffer();
		buff.writeBytes(((String) msg).getBytes());
		ch.writeAndFlush(buff);
		
		return null;
	}
}
