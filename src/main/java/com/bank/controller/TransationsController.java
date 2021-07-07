package com.bank.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Account;
import com.bank.model.Transaction;
import com.bank.response.ResponseMessage;
import com.bank.service.AccountService;
import com.bank.service.TransationsService;

@RestController
@RequestMapping("/api/v1/accounts/{accountId}/transactions")
public class TransationsController {

	@Autowired
	AccountService accountService;

	@Autowired
	TransationsService transationsService;

	@PostMapping("/")
	public ResponseEntity<Transaction> addTransations(@Valid @RequestBody Transaction transaction,
			@PathVariable("accountId") Long accountId) {
		Transaction addedtransations = transationsService.addTransations(accountId, transaction);

		return new ResponseEntity<Transaction>(addedtransations, HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<List<Transaction>> getTransations(@PathVariable("accountId") Long accoutId) {
		List<Transaction> transactions = transationsService.getTransations(accoutId);
		return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Transaction> getTransaction(@PathVariable("accountId") Long accountId,
			@PathVariable("id") Long id) {
		Transaction transaction = transationsService.getTransationsById(accountId, id);
		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseMessage> deleteTransation(@PathVariable("accountId") Long accountId,
			@PathVariable("id") Long id) {
		ResponseMessage responseMessage = new ResponseMessage();
		transationsService.deleteTransation(id);
		responseMessage.setId(id);
		responseMessage.setMessage("your transations has been deleted ");
		return new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Transaction> updateAccount(@PathVariable("accountId") Long accountId,@PathVariable("id") Long id, @RequestBody Transaction transaction) {
		Transaction updatedTransactions = transationsService.updatedTrasnsaction(accountId, id, transaction);
		return new ResponseEntity<Transaction>(updatedTransactions, HttpStatus.CREATED);
		
	}

}
