package com.example.banking.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.banking.model.Account;

public interface AccountRepository extends JpaRepository <Account,Long>
{
	List<Account> findByAccountNumber(String accountNumber);

}
