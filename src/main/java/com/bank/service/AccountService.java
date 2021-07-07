package com.bank.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.model.Account;

@Service
public interface AccountService {

	public Account createAccount(Account account);

	public List<Account> getAccounts();

	public Account getAccountById(Long id);
	
	public void deleteAccount(Long id);

	public Account updatedAccount(Long id, Account account);


}
