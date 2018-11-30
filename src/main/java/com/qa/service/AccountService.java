package com.qa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.ATS.Account;
import com.qa.repository.AccountRepository;
import com.qa.util.JSONUtil;

@Service
public class AccountService {

	@Autowired
	private AccountRepository repo;
	
	@Autowired
	private JSONUtil util;
	
	
	public Account mongoCreate(String acc) {
		
		Account accountToSend = util.fromJSON(acc, Account.class);
		
		return repo.insert(accountToSend);
	}
	
	public void setRepo(AccountRepository accRepo) {
		this.repo = accRepo;
	}
	
}
