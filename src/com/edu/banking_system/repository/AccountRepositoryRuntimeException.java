package com.edu.banking_system.repository;

public class AccountRepositoryRuntimeException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public AccountRepositoryRuntimeException() {
		super();
	}
	
	public AccountRepositoryRuntimeException(String message) {
		super(message);
	}
	
	public AccountRepositoryRuntimeException(Exception e) {
		super(e);
	}
	
	public AccountRepositoryRuntimeException(String message, Exception e) {
		super(message, e);
	}

}
