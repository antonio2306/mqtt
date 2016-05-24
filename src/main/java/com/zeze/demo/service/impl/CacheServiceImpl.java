package com.zeze.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeze.demo.cache.mapper.MqttClientMapper;
import com.zeze.demo.cache.repository.MqttClientRepository;
import com.zeze.demo.service.CacheService;

@Service
public class CacheServiceImpl implements CacheService {

	@Autowired
	MqttClientRepository mqttClientDao;
	
	@Override
	public String saveMqttClient(MqttClientMapper mqttClientMapper) {
		
		MqttClientMapper mqttClientMapperNew = mqttClientDao.save(mqttClientMapper);
		return mqttClientMapperNew.toString();
	}

	@Override
	public MqttClientMapper getMqttClientByUserName(String userName) {
		
		MqttClientMapper mqttClientMapperNew = mqttClientDao.findOne(userName);
		return mqttClientMapperNew;
	}

}
