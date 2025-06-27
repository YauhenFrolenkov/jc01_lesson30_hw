package com.edu.banking_system.util;

import java.util.NoSuchElementException;
import com.edu.banking_system.model.Account;
import com.edu.banking_system.repository.AccountRepository;
import com.edu.banking_system.repository.AccountRepositoryException;

public class AccountServiceUtils {

	public static Account getAccountOrThrow(AccountRepository repository, String accountId)
			throws AccountRepositoryException {
		return repository.findById(accountId)
				.orElseThrow(() -> new NoSuchElementException("Account not found: " + accountId));
	}

	public static void validatePositiveAmount(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Amount must be positive: " + amount);
		}
	}

	public static void validateSufficientBalance(Account account, double amount) {
		if (account.getBalance() < amount) {
			throw new IllegalArgumentException(
					"Insufficient balance. Available: " + account.getBalance() + ", required: " + amount);
		}
	}

}
