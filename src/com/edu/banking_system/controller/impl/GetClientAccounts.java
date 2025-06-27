package com.edu.banking_system.controller.impl;

import java.util.List;

import com.edu.banking_system.controller.Command;
import com.edu.banking_system.model.Account;
import com.edu.banking_system.service.AccountService;
import com.edu.banking_system.service.AccountServiceException;
import com.edu.banking_system.service.AccountServiceProvider;

public class GetClientAccounts implements Command {
	private final AccountService service = AccountServiceProvider.getInstance().getAccountService();

	@Override
	public String execute(String request) {
		String response;
		try {
			String[] params = request.split("\n");

			if (params.length < 2 || params[1].isBlank()) {
				return "Error: Client email is required.";
			}

			String email = params[1].trim();
			List<Account> accounts = service.getClientAccounts(email);

			if (accounts.isEmpty()) {
				return "No accounts found for email: " + email;
			}

			StringBuilder sb = new StringBuilder("Accounts for " + email + ":\n");
			for (Account acc : accounts) {
				sb.append("ID: ").append(acc.getId()).append(", Balance: ").append(acc.getBalance())
						.append(", Created: ").append(acc.getCreationDate()).append("\n");
			}
			response = sb.toString();
		} catch (AccountServiceException e) {
			response = "Error retrieving accounts.";
		}
		return response;
	}
}
