package com.edu.banking_system.util;

import java.time.LocalDate;

import com.edu.banking_system.model.Account;
import com.edu.banking_system.model.Client;

public class AccountParser {
	
	public static String serialize(Account account) {
        return String.join(";",
                account.getId(),
                account.getOwner().getName(),
                account.getOwner().getEmail(),
                account.getCreationDate().toString(),
                String.valueOf(account.getBalance())
        );
    }

    public static Account deserialize(String line) {
        String[] parts = line.split(";");
        if (parts.length != 5) {
            throw new IllegalArgumentException("Invalid account format: " + line);
        }

        String id = parts[0];
        String name = parts[1];
        String email = parts[2];
        LocalDate creationDate = LocalDate.parse(parts[3]);
        double balance = Double.parseDouble(parts[4]);

        Client client = new Client(name, email);
        return new Account(id, client, creationDate, balance);
    }

}
