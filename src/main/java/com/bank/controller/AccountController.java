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
import com.bank.response.ResponseDataEntity;
import com.bank.response.ResponseMessage;
import com.bank.service.AccountService;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

	@Autowired
	AccountService accountService;

	@PostMapping("/")
	public ResponseEntity<ResponseDataEntity> createAccount(@Valid @RequestBody Account account) {
		ResponseDataEntity responseDataEntity = new ResponseDataEntity();
		responseDataEntity.setStatus("success");
		responseDataEntity.setMessage("account created successfully");
		Account createdAcount = accountService.createAccount(account);
		responseDataEntity.setData(createdAcount);
		return new ResponseEntity<ResponseDataEntity>(responseDataEntity, HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<ResponseDataEntity> getAccounts() {
		ResponseDataEntity responseDataEntity = new ResponseDataEntity();
		responseDataEntity.setStatus("success");
		responseDataEntity.setMessage("account created successfully");
		List<Account> accounts = accountService.getAccounts();
		responseDataEntity.setData(accounts);
		return new ResponseEntity<ResponseDataEntity>(responseDataEntity, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Account> getAccounts(@PathVariable("id") Long id) {
		Account account = accountService.getAccountById(id);
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDataEntity> deleteAccount(@PathVariable("id") Long id) {
		ResponseDataEntity responseDataEntity = new ResponseDataEntity();
		responseDataEntity.setStatus("success");
		responseDataEntity.setMessage("account deleted successfully");
		accountService.deleteAccount(id);
		return new ResponseEntity<ResponseDataEntity>(responseDataEntity, HttpStatus.OK);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable("id") Long id, @RequestBody Account account) {
		Account updatedaccount = accountService.updatedAccount(id, account);
		return new ResponseEntity<Account>(updatedaccount, HttpStatus.CREATED);
	}

}
