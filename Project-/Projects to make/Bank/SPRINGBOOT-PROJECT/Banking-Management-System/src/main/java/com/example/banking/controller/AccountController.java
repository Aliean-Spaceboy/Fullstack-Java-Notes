package com.example.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.banking.model.Account;
import com.example.banking.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController
{
	@Autowired
	private AccountService accountService;
	@GetMapping
	public ResponseEntity<List<Account>>getAllAccounts()
	{
		List<Account>accounts=accountService.getAllAccounts();
		return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
	}
	public ResponseEntity<Account> createAccount(@RequestBody Account account)
	{
		Account createdAccount=accountService.createAccount(account);
		return new ResponseEntity<>(createdAccount,HttpStatus.CREATED);
	}
	@GetMapping("/account-number/{accountNumber}")
	public ResponseEntity<List<Account>>getAccountsByAccountNumber(@PathVariable String accountNumber)
	{
		List<Account>accounts=accountService.findByAccountNumber(accountNumber);
		if(accounts.isEmpty())
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(accounts,HttpStatus.OK);
	}
}
