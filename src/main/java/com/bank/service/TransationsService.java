package com.bank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.model.Transaction;

@Service
public interface TransationsService {

	Transaction addTransations(Long accountId, Transaction transaction);

	List<Transaction> getTransations(Long accoutId);

	Transaction getTransationsById(Long accountId, Long id);

	void deleteTransation(Long id);

	Transaction updatedTrasnsaction(Long accountId, Long id, Transaction transaction);

}
