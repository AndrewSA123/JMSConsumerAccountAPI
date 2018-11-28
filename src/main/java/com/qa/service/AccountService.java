package com.qa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.domain.Account;
import com.qa.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository repo;
	
	
	public Account mongoCreate(Account acc) {
		return repo.insert(acc);
	}
	
	public void setRepo(AccountRepository accRepo) {
		this.repo = accRepo;
	}
	
}
