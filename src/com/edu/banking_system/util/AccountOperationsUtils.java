package com.edu.banking_system.util;

import com.edu.banking_system.model.Account;
import com.edu.banking_system.repository.AccountRepository;
import com.edu.banking_system.repository.AccountRepositoryException;

public class AccountOperationsUtils {
	public static void deposit(AccountRepository repo, String accountId, double amount)
			throws AccountRepositoryException {
		Account account = AccountServiceUtils.getAccountOrThrow(repo, accountId);
		account.setBalance(account.getBalance() + amount);
		repo.updateAccount(account);
	}

	public static void withdraw(AccountRepository repo, String accountId, double amount)
			throws AccountRepositoryException {
		Account account = AccountServiceUtils.getAccountOrThrow(repo, accountId);
		AccountServiceUtils.validateSufficientBalance(account, amount);
		account.setBalance(account.getBalance() - amount);
		repo.updateAccount(account);
	}

	public static void transfer(AccountRepository repo, String fromId, String toId, double amount)
			throws AccountRepositoryException {
		Account from = AccountServiceUtils.getAccountOrThrow(repo, fromId);
		Account to = AccountServiceUtils.getAccountOrThrow(repo, toId);
		AccountServiceUtils.validateSufficientBalance(from, amount);

		from.setBalance(from.getBalance() - amount);
		to.setBalance(to.getBalance() + amount);

		repo.updateAccount(from);
		repo.updateAccount(to);
	}

}
