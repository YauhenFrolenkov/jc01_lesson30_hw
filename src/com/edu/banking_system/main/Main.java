package com.edu.banking_system.main;

import com.edu.banking_system.controller.Controller;
import com.edu.banking_system.ui.BankConsoleView;

public class Main {

	public static void main(String[] args) {
		BankConsoleView view = new BankConsoleView(new Controller());

		view.displayMenu();

	}

}
