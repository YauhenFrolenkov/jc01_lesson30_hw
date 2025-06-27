package com.edu.banking_system.service;

public class AccountServiceException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public AccountServiceException() {
        super();
    }

    public AccountServiceException(String message) {
        super(message);
    }

    public AccountServiceException(Exception e) {
        super(e);
    }

    public AccountServiceException(String message, Exception e) {
        super(message, e);
    }
	
}
