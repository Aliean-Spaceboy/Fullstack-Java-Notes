package com.example.banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.banking.model.Account;
import com.example.banking.repo.AccountRepository;

@Service
public class AccountService
{
	
	@Autowired
	private AccountRepository accountRepository;
	
	public List<Account>findByAccountNumber(String accountNumber)
	{
		return accountRepository.findByAccountNumber(accountNumber); 
	}
	public List<Account>getAllAccounts()
	{
		return accountRepository.findAll();
	}
	public Account createAccount (Account account)
	{
		return accountRepository.save(account);
	}
}
