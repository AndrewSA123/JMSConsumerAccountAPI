package com.qa.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.ATS.Account;
import com.qa.domain.ATP;
import com.qa.repository.AccountRepository;
import com.qa.util.JSONUtil;

@Service
public class AccountService {

	@Autowired
	private AccountRepository repo;
	
	@Autowired
	private JSONUtil util;
	
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	private Date date = new Date();

	private Long id = 0l;
	
	public Account mongoCreate(String acc) {
		
		Account accountToSend = util.fromJSON(acc, Account.class);
		
		ATP accountToPersist = new ATP();

		accountToPersist.setId(id);
		accountToPersist.setDate(dateFormat.format(date));
		accountToPersist.setAccount(util.toJSON(accountToSend));

		id++;
		repo.insert(accountToPersist);

		return accountToSend;
	}
	
	public void setRepo(AccountRepository accRepo) {
		this.repo = accRepo;
	}
	
}
