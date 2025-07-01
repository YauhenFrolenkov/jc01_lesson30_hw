package com.edu.banking_system.model;

public class Client extends Person{
	private static final long serialVersionUID = 1L;
	
	public Client () {
	}
	
	public Client(String name, String email) {
        super(name, email);
    }
	
	@Override
    public String toString() {
        return "Client [name=" + getName() + ", email=" + getEmail() + "]";
    }
		
}
