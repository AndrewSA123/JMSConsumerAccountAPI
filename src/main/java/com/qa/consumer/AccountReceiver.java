package com.qa.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.qa.ATS.Account;
import com.qa.service.AccountService;

@Component
@CrossOrigin
public class AccountReceiver {
	
	@Autowired
	private AccountService service;

	@JmsListener(destination = "accountQueue", containerFactory = "jmsContainerFactory")
	public Account receiveMessage(String acc) {
		
		System.out.println("this is coming off the queue");
		return service.mongoCreate(acc);
	}
	
}
