package com.edu.banking_system.repository;

import com.edu.banking_system.repository.impl.FileAccountRepository;

public class AccountRepositoryProvider {
	private static final AccountRepositoryProvider instance = new AccountRepositoryProvider();

	private final AccountRepository accountRepository = new FileAccountRepository(); 

	private AccountRepositoryProvider() {
	}

	public AccountRepository getAccountRepository() {
		return accountRepository;
	}

	public static AccountRepositoryProvider getInstance() {
		return instance;
	}

}
