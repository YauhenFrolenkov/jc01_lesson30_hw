package com.edu.banking_system.controller.impl;

import com.edu.banking_system.controller.Command;
import com.edu.banking_system.model.Account;
import com.edu.banking_system.model.Client;
import com.edu.banking_system.service.AccountService;
import com.edu.banking_system.service.AccountServiceException;
import com.edu.banking_system.service.AccountServiceProvider;

public class CreateAccount implements Command {
	private final AccountService service = AccountServiceProvider.getInstance().getAccountService();

	@Override
	public String execute(String request) {
		String response;
		try {
			String[] params = request.split("\n");

			if (params.length < 4) {
				return "Error: Not enough parameters. Expected: id, client name, client email.";
			}

			String id = params[1].trim();
			String name = params[2].trim();
			String email = params[3].trim();

			Account account = new Account(id, new Client(name, email));

			service.createAccount(account);
			response = "Account created successfully: " + id;
		} catch (AccountServiceException e) {
			response = "Error creating account.";
		}
		return response;
	}

}
