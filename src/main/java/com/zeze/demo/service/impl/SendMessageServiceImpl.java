package com.zeze.demo.service.impl;


import io.netty.channel.ChannelId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeze.demo.cache.mapper.ChannelidMapper;
import com.zeze.demo.cache.repository.ChannelidRepository;
import com.zeze.demo.netty.ChannelMap;
import com.zeze.demo.service.SendMessageService;

@Service
public class SendMessageServiceImpl implements SendMessageService {

	@Autowired
	ChannelidRepository channelidDao;
	
	@Override
	public String recvMsg(ChannelId id, Object msg) {
		
		saveChannelId("0007", id);
		
		System.out.println(msg);
		return "pong\r\n";
	}

	@Override
	public String saveChannelId(String did, ChannelId id) {
		
//		ChannelidMapper channelidMapper = new ChannelidMapper();
//		channelidMapper.setDid(did);
//		channelidMapper.setChannelid(id);
//		channelidDao.save(channelidMapper);
		ChannelMap.add(did, id);
		
		return null;
	}
	
}
