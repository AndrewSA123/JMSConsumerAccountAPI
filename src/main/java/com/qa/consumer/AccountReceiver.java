package com.qa.consumer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.qa.ATS.Account;
import com.qa.service.AccountService;

@Component
public class AccountReceiver {
	
	@Autowired
	private AccountService service;

	
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	private Date date = new Date();
	
	private Long id = 0l;

	@JmsListener(destination = "accountQueue", containerFactory = "jmsContainerFactory")
	public Account receiveMessage(String acc) {
		
//		acc.setDate(dateFormat.format(date));
		id++;
		System.out.println("this is coming off the queue");
//		return new Account();
		return service.mongoCreate(acc);
	}
	
}
