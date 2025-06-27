package com.edu.banking_system.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import com.edu.banking_system.model.Account;
import com.edu.banking_system.repository.AccountRepository;
import com.edu.banking_system.repository.AccountRepositoryException;
import com.edu.banking_system.repository.AccountRepositoryProvider;
import com.edu.banking_system.service.AccountService;
import com.edu.banking_system.service.AccountServiceException;
import com.edu.banking_system.util.AccountOperationsUtils;
import com.edu.banking_system.util.AccountServiceUtils;

public class AccountManagementService implements AccountService {
	private final AccountRepository accountRepository;

	{
		AccountRepositoryProvider provider = AccountRepositoryProvider.getInstance();
		accountRepository = provider.getAccountRepository();
	}

	public AccountManagementService() {
	}
	
	@Override
	public void createAccount(Account account) throws AccountServiceException {
		try {
			accountRepository.addNewAccount(account);
		} catch (AccountRepositoryException e) {
			throw new AccountServiceException(e);
		}
	}
	
	@Override
	public void deposit(String accountId, double amount) throws AccountServiceException {
		try {
			AccountServiceUtils.validatePositiveAmount(amount);
			AccountOperationsUtils.deposit(accountRepository, accountId, amount);
		} catch (NoSuchElementException | AccountRepositoryException e) {
			throw new AccountServiceException(e);
		}
	}

	@Override
	public void withdraw(String accountId, double amount) throws AccountServiceException {
		try {
			AccountServiceUtils.validatePositiveAmount(amount);
			AccountOperationsUtils.withdraw(accountRepository, accountId, amount);
		} catch (NoSuchElementException | AccountRepositoryException e) {
			throw new AccountServiceException(e);
		}
	}

	@Override
	public void transfer(String fromAccountId, String toAccountId, double amount) throws AccountServiceException {
		try {
			AccountServiceUtils.validatePositiveAmount(amount);
			AccountOperationsUtils.transfer(accountRepository, fromAccountId, toAccountId, amount);
		} catch (NoSuchElementException | AccountRepositoryException e) {
			throw new AccountServiceException(e);
		}
	}

	@Override
	public List<Account> getClientAccounts(String email) throws AccountServiceException {
		try {
			return accountRepository.findByClientEmail(email);
		} catch (AccountRepositoryException e) {
			throw new AccountServiceException(e);
		}
	}

	@Override
	public void deleteAccount(String accountId) throws AccountServiceException {
		try {
			Account account = AccountServiceUtils.getAccountOrThrow(accountRepository, accountId);
			accountRepository.deleteAccountById(account.getId());
		} catch (NoSuchElementException | AccountRepositoryException e) {
			throw new AccountServiceException(e);
		}
	}

}
