package com.edu.banking_system.model;

public class Manager extends Person{
	private static final long serialVersionUID = 1L;
	
	public Manager() {
        super();
    }

    public Manager(String name, String email) {
        super(name, email);
    }
    
    @Override
    public String toString() {
        return "Manager [name=" + getName() + ", email=" + getEmail() + "]";
    }

}
