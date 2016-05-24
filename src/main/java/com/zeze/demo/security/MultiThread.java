package com.zeze.demo.security;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class MultiThread {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {

		@SuppressWarnings("rawtypes")
		BlockingQueue queue = new ArrayBlockingQueue(1024);  
		
        Thread.currentThread().sleep(4000); 
     
	}
	
	class ThreadPerTaskExecutor implements Executor {
		public void execute(Runnable r) {
			new Thread(r).start();
		}
	}

}
