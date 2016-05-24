package com.zeze.demo.netty;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * 超时断连handler
 * @author Administrator
 *
 */
public class TimeoutHandler extends ChannelHandlerAdapter {

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt)
			throws Exception {
		if (evt instanceof IdleStateEvent) {
			IdleStateEvent e = (IdleStateEvent) evt;
			if (e.state() == IdleState.READER_IDLE) {
				System.out.println("time out!");
				ctx.close();
			} else if (e.state() == IdleState.WRITER_IDLE) {
				ctx.writeAndFlush("");
			}
		}
	}
}
