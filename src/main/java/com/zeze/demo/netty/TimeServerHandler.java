package com.zeze.demo.netty;


import java.io.UnsupportedEncodingException;



import com.zeze.demo.service.impl.SendMessageServiceImpl;
import com.zeze.demo.util.SpringServerContextsUtil;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;

public class TimeServerHandler extends ChannelHandlerAdapter {

	public static ChannelGroup channelGroup = new DefaultChannelGroup("client-channel-group", null);
	
	SendMessageServiceImpl sendMessageService = (SendMessageServiceImpl) 
			SpringServerContextsUtil.getBean("SendMessageServiceImpl");
	
	AttributeKey<Integer> KEY_FLAG = AttributeKey.valueOf("flag");  
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		
		Attribute<Integer> flagKey = ctx.channel().attr(KEY_FLAG);
		flagKey.set(0);
		
		ByteBuf in = (ByteBuf) msg;
		ChannelId id = ctx.channel().id();
		byte[] dst = new byte[in.capacity()];
		in.getBytes(0, dst);
		try {
			String str =new String(dst,"UTF-8");
			String rmsg = sendMessageService.recvMsg(id, str);
			ByteBuf buff = ctx.alloc().buffer();
			buff.writeBytes(rmsg.getBytes());
            ctx.writeAndFlush(buff);
            
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception { // (5)
		
		Attribute<Integer> flagKey = ctx.channel().attr(KEY_FLAG);
		flagKey.set(0);
		
		//设置心跳时间
		ctx.channel().pipeline().addAfter("MqttDecoder", "IdleStateHandler", new IdleStateHandler(300, 0, 0));
		//设置心跳超时处理方法
		ctx.channel().pipeline().addAfter("IdleStateHandler", "TimeoutHandler", new TimeoutHandler());
		
		Channel incoming = ctx.channel();
		channelGroup.add(incoming);
		System.out.println("SimpleChatClient:" + incoming.remoteAddress()
				+ "在线");
	}
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception { // (6)
		
		ctx.channel().attr(KEY_FLAG).remove();
		Channel incoming = ctx.channel();
		//id 与  did 对应关系移除
		channelGroup.remove(incoming);
		System.out.println("SimpleChatClient:" + incoming.remoteAddress()
				+ "掉线");
	}
	
}
