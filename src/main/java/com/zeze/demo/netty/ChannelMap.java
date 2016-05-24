package com.zeze.demo.netty;

import io.netty.channel.ChannelId;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ChannelMap {

	private static Map<String,ChannelId> map=new ConcurrentHashMap<String, ChannelId>();
    public static void add(String clientId,ChannelId channelId){
        map.put(clientId,channelId);
    }
    public static ChannelId get(String clientId){
       return map.get(clientId);
    }
    public static void remove(ChannelId channelId){
        for (Map.Entry entry:map.entrySet()){
            if (entry.getValue()==channelId){
                map.remove(entry.getKey());
            }
        }
    }
}
