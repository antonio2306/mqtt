package com.zeze.demo.mina;


import org.apache.commons.lang.StringUtils;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RobotServerHandle extends IoHandlerAdapter{

	protected static Logger logger = LoggerFactory.getLogger(RobotServerHandle.class);

    @Override
    public void exceptionCaught( IoSession session, Throwable cause ) throws Exception {
        cause.printStackTrace();
    }

    @Override
    public void messageReceived( IoSession session, Object message ) throws Exception {
        String str = message.toString();        
        if( str.trim().equalsIgnoreCase("quit") ) {
            session.close();
            return;
        }
        
        if(StringUtils.isBlank(str)){
        	logger.info("received message is null");
        	return;
        }
        session.write(message);
    }

    @Override
    public void sessionIdle( IoSession session, IdleStatus status ) throws Exception {
    	//System.out.println( "IDLE " + session.getIdleCount( status ));
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
    	logger.info("messageSent:" + message.toString());
    	//System.out.println( "messageSent:" + message.toString());
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {

    	logger.info("session opened  sessionid ："+session.getId()+" client port:"+session.getRemoteAddress().toString());
    	//System.out.println( "链接已接入: " + session.getId());
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {

    	System.out.println( "链接已断开");
    }

}
