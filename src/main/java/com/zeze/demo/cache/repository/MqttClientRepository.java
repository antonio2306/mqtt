package com.zeze.demo.cache.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.zeze.demo.cache.mapper.MqttClientMapper;

public interface MqttClientRepository extends PagingAndSortingRepository<MqttClientMapper, String> {

}
