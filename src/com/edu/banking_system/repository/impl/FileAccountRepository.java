package com.edu.banking_system.repository.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.edu.banking_system.model.Account;
import com.edu.banking_system.repository.AccountRepository;
import com.edu.banking_system.repository.AccountRepositoryException;
import com.edu.banking_system.repository.AccountRepositoryRuntimeException;
import com.edu.banking_system.util.AccountParser;

public class FileAccountRepository implements AccountRepository {
	private final File FILE_PATH = new File("accounts.txt");

	public FileAccountRepository() {
		try {
			if (!FILE_PATH.exists()) {
				FILE_PATH.createNewFile();
			}
		} catch (IOException e) {
			throw new AccountRepositoryRuntimeException("Failed to create file: accounts.txt", e);
		}
	}
	
	@Override
	public void addNewAccount(Account account) throws AccountRepositoryException {
		try {
			List<Account> accounts = findAllAccounts();
			for (Account acc : accounts) {
				if (acc.getId().equalsIgnoreCase(account.getId())) {
					throw new AccountRepositoryException("Account with this ID already exists: " + account.getId());
				}
			}
			accounts.add(account);
			writeAllAccounts(accounts);
		} catch (IOException e) {
			throw new AccountRepositoryException(e);
		}
	}

	@Override
	public void updateAccount(Account account) throws AccountRepositoryException {
		try {
			List<Account> accounts = findAllAccounts();
			boolean found = false;

			for (int i = 0; i < accounts.size(); i++) {
				if (accounts.get(i).getId().equalsIgnoreCase(account.getId())) {
					accounts.set(i, account);
					found = true;
					break;
				}
			}

			if (!found) {
				throw new AccountRepositoryException("Account not found for update: " + account.getId());
			}

			writeAllAccounts(accounts);
		} catch (IOException e) {
			throw new AccountRepositoryException(e);
		}
	}

	@Override
	public void deleteAccountById(String id) throws AccountRepositoryException {
		try {
			List<Account> accounts = findAllAccounts();
			boolean removed = accounts.removeIf(acc -> acc.getId().equalsIgnoreCase(id));
			if (!removed) {
				throw new AccountRepositoryException("Account not found for deletion: " + id);
			}
			writeAllAccounts(accounts);
		} catch (IOException e) {
			throw new AccountRepositoryException(e);
		}
	}

	@Override
	public List<Account> findAllAccounts() throws AccountRepositoryException {
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
			List<Account> result = new ArrayList<>();
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.isBlank()) {
					continue;
				}
				result.add(AccountParser.deserialize(line));
			}
			return result;
		} catch (IOException | IllegalArgumentException e) {
			throw new AccountRepositoryException(e);
		}
	}

	@Override
	public Optional<Account> findById(String id) throws AccountRepositoryException {
		return findAllAccounts().stream().filter(acc -> acc.getId().equalsIgnoreCase(id)).findFirst();
	}

	@Override
	public List<Account> findByClientEmail(String email) throws AccountRepositoryException {
		return findAllAccounts().stream().filter(acc -> acc.getOwner().getEmail().equalsIgnoreCase(email)).toList();
	}

	private void writeAllAccounts(List<Account> accounts) throws IOException {
		try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
			for (Account acc : accounts) {
				writer.println(AccountParser.serialize(acc));
			}
		}
	}

}
