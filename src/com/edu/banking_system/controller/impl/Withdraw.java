package com.edu.banking_system.controller.impl;

import com.edu.banking_system.controller.Command;
import com.edu.banking_system.service.AccountService;
import com.edu.banking_system.service.AccountServiceException;
import com.edu.banking_system.service.AccountServiceProvider;

public class Withdraw implements Command {
	private final AccountService service = AccountServiceProvider.getInstance().getAccountService();

	@Override
	public String execute(String request) {
		String response;
		try {
			String[] params = request.split("\n");

			if (params.length < 3) {
				return "Error: Not enough parameters. Expected: accountId, amount.";
			}

			String accountId = params[1].trim();
			double amount = Double.parseDouble(params[2].trim());

			service.withdraw(accountId, amount);
			response = "Withdrawal successful from account: " + accountId;
		} catch (NumberFormatException e) {
            response = "Invalid amount format. Please enter a valid number.";
        } catch (AccountServiceException e) {
            response = "Error performing withdrawal.";
        }
		return response;
	}

}
