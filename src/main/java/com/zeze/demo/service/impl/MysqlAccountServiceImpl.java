package com.zeze.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeze.demo.mybatis.auto.TAccount;
import com.zeze.demo.mybatis.auto.TAccountExample;
import com.zeze.demo.mybatis.auto.TAccountMapper;
import com.zeze.demo.service.MysqlAccountService;

@Service
public class MysqlAccountServiceImpl implements MysqlAccountService {

	@Autowired
	TAccountMapper tAccountMapper;
	
	@Override
	public List<TAccount> find(String userName, String passwd) {
		
		TAccountExample example = new TAccountExample();
		TAccountExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userName);
		criteria.andUserPwEqualTo(passwd);
		List<TAccount> taccounts = tAccountMapper.selectByExample(example);
		return taccounts;
	}
	
}
