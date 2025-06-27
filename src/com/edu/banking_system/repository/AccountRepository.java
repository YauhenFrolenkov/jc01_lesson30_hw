package com.edu.banking_system.repository;

import java.util.List;
import java.util.Optional;
import com.edu.banking_system.model.Account;

public interface AccountRepository {
	void addNewAccount(Account account) throws AccountRepositoryException;

    void updateAccount(Account account) throws AccountRepositoryException;
    
    void deleteAccountById(String id) throws AccountRepositoryException;

    List<Account> findAllAccounts() throws AccountRepositoryException;

    Optional<Account> findById(String id) throws AccountRepositoryException;

    List<Account> findByClientEmail(String email) throws AccountRepositoryException;

}
