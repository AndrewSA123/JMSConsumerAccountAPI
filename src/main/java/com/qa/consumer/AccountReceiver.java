package com.qa.consumer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.qa.domain.Account;
import com.qa.service.AccountService;

@Component
public class AccountReceiver {
	
	@Autowired
	private AccountService service;

	
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	private Date date = new Date();
	
	private Long id;

	@JmsListener(destination = "accountQueue", containerFactory = "myFactory")
	public Account receiveMessage(Account acc) {
		
		acc.setId(id);
		acc.setDate(dateFormat.format(date));
		id++;
		return service.mongoCreate(acc);
	}
	
}
