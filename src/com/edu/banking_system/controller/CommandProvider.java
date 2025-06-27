package com.edu.banking_system.controller;

import java.util.HashMap;
import java.util.Map;
import com.edu.banking_system.controller.impl.*;

public class CommandProvider {
	private final Map<CommandName, Command> repository = new HashMap<>();
	
	CommandProvider() {
        repository.put(CommandName.CREATE_ACCOUNT, new CreateAccount());
        repository.put(CommandName.DEPOSIT, new Deposit());
        repository.put(CommandName.WITHDRAW, new Withdraw());
        repository.put(CommandName.TRANSFER, new Transfer());
        repository.put(CommandName.GET_CLIENT_ACCOUNTS, new GetClientAccounts());
        repository.put(CommandName.DELETE_ACCOUNT, new DeleteAccount());
        repository.put(CommandName.WRONG_REQUEST, new NoSuchCommand());
    }
	
	Command getCommand(String name) {
        CommandName commandName = null;
        Command command = null;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            command = repository.get(CommandName.WRONG_REQUEST);
        }

        return command;
    }


}
