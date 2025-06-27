package com.edu.banking_system.ui;

import java.util.Scanner;

import com.edu.banking_system.controller.Controller;

public class BankConsoleView {
	private final Scanner scanner = new Scanner(System.in);
	private final Controller controller;

	public BankConsoleView(Controller controller) {
		this.controller = controller;
	}

	public void displayMenu() {
		while (true) {
			System.out.println("\n==== Banking System Menu ====");
			System.out.println("1. Create Account");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Transfer");
			System.out.println("5. Get Client Accounts");
			System.out.println("6. Delete Account");
			System.out.println("7. Exit");
			System.out.print("Choose option: ");

			int choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {
			case 1 -> createAccount();
			case 2 -> deposit();
			case 3 -> withdraw();
			case 4 -> transfer();
			case 5 -> getClientAccounts();
			case 6 -> deleteAccount();
			case 7 -> {
				System.out.println("Exiting.");
				return;
			}
			default -> System.out.println("Invalid option.");
			}
		}
	}
	
	private void createAccount() {
		System.out.print("Account ID: ");
		String id = scanner.nextLine();
		System.out.print("Client name: ");
		String name = scanner.nextLine();
		System.out.print("Client email: ");
		String email = scanner.nextLine();

		String request = "CREATE_ACCOUNT\n" + id + "\n" + name + "\n" + email;
		String response = controller.doAction(request);
		System.out.println(response);
	}
	
	private void deposit() {
		System.out.print("Account ID: ");
		String id = scanner.nextLine();
		System.out.print("Amount to deposit: ");
		String amount = scanner.nextLine();

		String request = "DEPOSIT\n" + id + "\n" + amount;
		String response = controller.doAction(request);
		System.out.println(response);
	}
	
	private void withdraw() {
		System.out.print("Account ID: ");
		String id = scanner.nextLine();
		System.out.print("Amount to withdraw: ");
		String amount = scanner.nextLine();

		String request = "WITHDRAW\n" + id + "\n" + amount;
		String response = controller.doAction(request);
		System.out.println(response);
	}
	
	private void transfer() {
		System.out.print("From Account ID: ");
		String fromId = scanner.nextLine();
		System.out.print("To Account ID: ");
		String toId = scanner.nextLine();
		System.out.print("Amount to transfer: ");
		String amount = scanner.nextLine();

		String request = "TRANSFER\n" + fromId + "\n" + toId + "\n" + amount;
		String response = controller.doAction(request);
		System.out.println(response);
	}
	
	private void getClientAccounts() {
		System.out.print("Client email: ");
		String email = scanner.nextLine();

		String request = "GET_CLIENT_ACCOUNTS\n" + email;
		String response = controller.doAction(request);
		System.out.println(response);
	}

	private void deleteAccount() {
		System.out.print("Account ID: ");
		String id = scanner.nextLine();

		String request = "DELETE_ACCOUNT\n" + id;
		String response = controller.doAction(request);
		System.out.println(response);
	}

}
