package com.edu.banking_system.service;

import com.edu.banking_system.service.impl.AccountManagementService;

public class AccountServiceProvider {
	private static final AccountServiceProvider instance = new AccountServiceProvider();

    private final AccountService accountService = new AccountManagementService();

    private AccountServiceProvider() {
    }

    public static AccountServiceProvider getInstance() {
        return instance;
    }

    public AccountService getAccountService() {
        return accountService;
    }
    																																																																											
}
