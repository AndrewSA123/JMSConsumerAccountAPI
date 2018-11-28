package com.qa.domain;

public class Account {
	

	private Long id;
	private String account;
	private String date;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Account() {
		
	}
	
	public Account(String acc) {
		this.account = acc;
	}
	
	public String getAccount() {
		return this.account;
	}
	
	public void setAccount(String acc) {
		this.account = acc;
	}
	
	@Override
	public String toString() {
		return "Account [account=" + this.account + "]";
	}

}
