package com.bank.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.model.Account;
import com.bank.repository.AccountRepository;
import com.bank.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	
	@Override
	public Account createAccount(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public List<Account> getAccounts() {
		return accountRepository.findAll();
	}

	@Override
	public Account getAccountById(Long id) {
		Optional<Account> optionalAccount = accountRepository.findById(id);
		if(optionalAccount.isPresent()) {
			return optionalAccount.get();
		}else {
			return null;
		}
	}
	
	@Override
	public void deleteAccount(Long id) {
		accountRepository.deleteById(id);
	}

	@Override
	public Account updatedAccount(Long id, Account account) {
		ModelMapper modelMapper = new ModelMapper();
		Account dbaccount =  getAccountById(id);
		Account account2 = modelMapper.map(dbaccount, Account.class);
		account2.setId(id);
		return accountRepository.save(account2);
	}
	
	

}
