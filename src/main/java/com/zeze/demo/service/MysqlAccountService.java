package com.zeze.demo.service;

import java.util.List;

import com.zeze.demo.mybatis.auto.TAccount;

public interface MysqlAccountService {

	public List<TAccount> find(String userName, String passwd);
	
}
