package com.zeze.demo.cache.mapper;


import io.netty.channel.ChannelId;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Document
public class ChannelidMapper implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String did;	      		 //key
	@Field
	private ChannelId channelId;	 //
	
	
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public ChannelId getChannelid() {
		return channelId;
	}
	public void setChannelid(ChannelId channelId) {
		this.channelId = channelId;
	}

}
