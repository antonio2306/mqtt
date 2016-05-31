package com.zeze.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zeze.demo.service.ContollerService;



@Controller
public class MessagePassController {

	@Autowired
	ContollerService contollerService;

	@RequestMapping(value="/msg/send", method = RequestMethod.GET)
	@ResponseBody
	public String sendMessage(String msg) {
		
		String rslt = contollerService.sendMsg(msg);
		return rslt;
	}
}
