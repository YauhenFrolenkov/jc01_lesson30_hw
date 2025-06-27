package com.edu.banking_system.service;

import java.util.List;
import com.edu.banking_system.model.Account;

public interface AccountService {
	void createAccount(Account account) throws AccountServiceException;

    void deposit(String accountId, double amount) throws AccountServiceException;

    void withdraw(String accountId, double amount) throws AccountServiceException;

    void transfer(String fromAccountId, String toAccountId, double amount) throws AccountServiceException;

    List<Account> getClientAccounts(String clientEmail) throws AccountServiceException;

    void deleteAccount(String accountId) throws AccountServiceException;

}
