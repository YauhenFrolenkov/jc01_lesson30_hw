package com.edu.banking_system.controller.impl;

import com.edu.banking_system.controller.Command;

public class NoSuchCommand implements Command {
	
	@Override
	public String execute(String request) {
		return "Request error";
	}

}
