package com.edu.banking_system.controller.impl;

import com.edu.banking_system.controller.Command;
import com.edu.banking_system.service.AccountService;
import com.edu.banking_system.service.AccountServiceException;
import com.edu.banking_system.service.AccountServiceProvider;

public class DeleteAccount implements Command {
	private final AccountService service = AccountServiceProvider.getInstance().getAccountService();

	@Override
	public String execute(String request) {
		String response;
		try {
			String[] params = request.split("\n");

			if (params.length < 2 || params[1].isBlank()) {
				return "Error: Account ID is required.";
			}

			String accountId = params[1].trim();

			service.deleteAccount(accountId);
			response = "Account deleted: " + accountId;
		} catch (AccountServiceException e) {
			response = "Error deleting account.";
		}
		return response;
	}

}
