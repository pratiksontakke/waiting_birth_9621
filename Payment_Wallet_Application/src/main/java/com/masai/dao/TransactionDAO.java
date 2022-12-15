package com.masai.dao;

import com.masai.exception.LoginException;
import com.masai.exception.TransactionException;
import com.masai.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface TransactionDAO extends JpaRepository<Transaction, Integer> {

    public Set<Transaction> findByTransactionType(String transactionType) throws TransactionException;

    public Set<Transaction> findByTransactionDateBetween(LocalDate dateFrom, LocalDate dateTo) throws TransactionException, LoginException;
}
