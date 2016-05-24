package com.zeze.demo.security;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class MyEncript {

	
	public static void selectorTest() throws IOException {
		
		Selector selector = Selector.open();
		SocketChannel channel = SocketChannel.open();
		channel.socket().bind(new InetSocketAddress(8877));
		channel.configureBlocking(false);

		SelectionKey key = channel.register(selector, SelectionKey.OP_READ);

		while(true) {

		  int readyChannels = selector.select();

		  if(readyChannels == 0) continue;

		  Set<SelectionKey> selectedKeys = selector.selectedKeys();

		  Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

		  while(keyIterator.hasNext()) {

		    SelectionKey key1 = keyIterator.next();

		    if(key1.isAcceptable()) {
		        // a connection was accepted by a ServerSocketChannel.

		    } else if (key1.isConnectable()) {
		        // a connection was established with a remote server.

		    } else if (key1.isReadable()) {
		        // a channel is ready for reading
		    	
		    } else if (key1.isWritable()) {
		        // a channel is ready for writing
		    	
		    }

		    keyIterator.remove();
		  }
		}
		
	}
	
	
	
	public static void main(String args[]) throws IOException {
		
		selectorTest();
		
//		RandomAccessFile aFile = new RandomAccessFile("e://hello.txt", "rw");
//	    FileChannel inChannel = aFile.getChannel();
//
//	    ByteBuffer buf = ByteBuffer.allocate(48);
//
//	    int bytesRead = inChannel.read(buf);
//	    while (bytesRead != -1) {
//
//	      System.out.println("Read " + bytesRead);
//	      buf.flip();
//
//	      while(buf.hasRemaining()){
//	          System.out.print((char) buf.get());
//	      }
//
//	      buf.clear();
//	      bytesRead = inChannel.read(buf);
//	    }
//	    aFile.close();
		
		AtomicInteger a;
		
	}
	
}
