package com.edu.banking_system.controller.impl;

import com.edu.banking_system.controller.Command;
import com.edu.banking_system.service.AccountService;
import com.edu.banking_system.service.AccountServiceException;
import com.edu.banking_system.service.AccountServiceProvider;

public class Transfer implements Command {
	private final AccountService service = AccountServiceProvider.getInstance().getAccountService();

	@Override
	public String execute(String request) {
		String response;
		try {
			String[] params = request.split("\n");

			if (params.length < 4) {
				return "Error: Not enough parameters. Expected: fromAccountId, toAccountId, amount.";
			}

			String fromId = params[1].trim();
			String toId = params[2].trim();
			double amount = Double.parseDouble(params[3].trim());

			service.transfer(fromId, toId, amount);
			response = "Transfer successful: " + amount + " from " + fromId + " to " + toId;
		} catch (NumberFormatException e) {
            response = "Invalid amount format. Please enter a valid number.";
        } catch (AccountServiceException e) {
            response = "Error performing transfer.";
        }
		return response;
	}
	
	

}
