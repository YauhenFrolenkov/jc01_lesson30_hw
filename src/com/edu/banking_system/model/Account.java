package com.edu.banking_system.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	private final String id;
	private final Client owner;
	private final LocalDate creationDate;
	private double balance;

	public Account() {
		this.id = "";
		this.owner = new Client();
		this.creationDate = LocalDate.now();
		this.balance = 0.0;
	}

	public Account(String id, Client owner) {
		this.id = id;
		this.owner = owner;
		this.creationDate = LocalDate.now();
		this.balance = 0.0;
	}
	
	public Account(String id, Client owner, LocalDate creationDate, double balance) {
        this.id = id;
        this.owner = owner;
        this.creationDate = creationDate;
        this.balance = balance;
    }

	public String getId() {
		return id;
	}

	public Client getOwner() {
		return owner;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(balance, creationDate, id, owner);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& Objects.equals(creationDate, other.creationDate) && Objects.equals(id, other.id)
				&& Objects.equals(owner, other.owner);
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", owner=" + owner + ", creationDate=" + creationDate + ", balance=" + balance
				+ "]";
	}

}
