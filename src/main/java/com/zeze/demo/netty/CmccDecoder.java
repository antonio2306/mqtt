package com.zeze.demo.netty;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;

/**
 * 
 * @author Administrator
 *
 */
public class CmccDecoder extends ByteToMessageDecoder{
	
	public class CmccLengthFieldBasedFrameDecoder extends LengthFieldBasedFrameDecoder {

		public CmccLengthFieldBasedFrameDecoder(int maxFrameLength,
				int lengthFieldOffset, int lengthFieldLength) {
			super(maxFrameLength, lengthFieldOffset, lengthFieldLength);
		}
		
		void dodecode(ChannelHandlerContext ctx, ByteBuf in,
				List<Object> out) throws Exception {
			super.decode(ctx, in, out);
		}
	}
	
	public class CmccLineBasedFrameDecoder extends LineBasedFrameDecoder {

		public CmccLineBasedFrameDecoder(int maxLength) {
			super(maxLength);
		}
		
		void dodecode(ChannelHandlerContext ctx, ByteBuf in,
				List<Object> out) throws Exception {
			super.decode(ctx, in, out);
		}
	}
	
	CmccLengthFieldBasedFrameDecoder lengthFieldBasedFrameDecoder = new CmccLengthFieldBasedFrameDecoder(10240, 0, 2);
	CmccLineBasedFrameDecoder lineBasedFrameDecoder = new CmccLineBasedFrameDecoder(10240);
	
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in,
			List<Object> out) throws Exception {
		System.out.println(in.getByte(0));
		AttributeKey<Integer> KEY_FLAG = AttributeKey.valueOf("flag");  
		Attribute<Integer> flagKey = ctx.channel().attr(KEY_FLAG);
		Integer flag = flagKey.get();
		
		if (flag.equals(0)) {
			if (in.getByte(0) != (byte)0x55 ){
				
				lineBasedFrameDecoder.dodecode( ctx,  in,  out);
				flagKey.set(2);
			} else if (in.getByte(0) == (byte)0x55 ) {
				
				System.out.println(in.toString());
				//第一个字节为包头  去除
				in.readBytes(1);
				lengthFieldBasedFrameDecoder.dodecode(ctx,  in.discardReadBytes(),  out);
				flagKey.set(1);	
			}  
			
		} else if (flag.equals(2)) {
			
			lineBasedFrameDecoder.dodecode( ctx,  in,  out);
			flagKey.set(2);
		} else if (flag.equals(1)) {
			
			lengthFieldBasedFrameDecoder.dodecode( ctx,  in,  out);
			flagKey.set(1);
		}
		
	}

	
}
