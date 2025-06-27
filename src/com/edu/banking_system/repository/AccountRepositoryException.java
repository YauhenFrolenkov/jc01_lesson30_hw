package com.edu.banking_system.repository;

public class AccountRepositoryException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public AccountRepositoryException() {
		super();
	}
	
	public AccountRepositoryException(String message) {
		super(message);
	}
	
	public AccountRepositoryException(Exception e) {
		super(e);
	}
	
	public AccountRepositoryException(String message, Exception e) {
		super(message, e);
	}
	

}
