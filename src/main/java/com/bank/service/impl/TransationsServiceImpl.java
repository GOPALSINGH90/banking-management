package com.bank.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.model.Account;
import com.bank.model.Transaction;
import com.bank.repository.TransationsRepository;
import com.bank.service.AccountService;
import com.bank.service.TransationsService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Service
public class TransationsServiceImpl implements TransationsService {

	@Autowired
	AccountService accountService;

	@Autowired
	TransationsRepository transationsRepository;

	@Override
	public Transaction addTransations(Long accountId, Transaction transaction) {
		Account account = accountService.getAccountById(accountId);
		transaction.setAccount(account);
		return transationsRepository.save(transaction);
	}

	@Override
	public List<Transaction> getTransations(Long accoutId) {
		return transationsRepository.findByAccountsId(accoutId);
	}

	@Override
	public Transaction getTransationsById(Long accountId, Long id) {

		return transationsRepository.getByAccountsIdAndId(accountId, id);
	}

	@Override
	public void deleteTransation(Long id) {
		transationsRepository.deleteById(id);
	}

	@Override
	public Transaction updatedTrasnsaction(Long accountId,Long id, Transaction transaction) {
		Transaction transaction2 = getTransationsById(accountId, id);
		transaction2.setAmount(transaction.getAmount());
		transaction2.setDescription(transaction.getDescription());
		transaction2.setType(transaction.getType());
		return transationsRepository.save(transaction2);
	}
}
