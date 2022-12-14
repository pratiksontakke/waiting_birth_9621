package com.masai.dao;

import com.masai.exception.TransactionException;
import com.masai.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionDAO extends JpaRepository<Transaction, Integer> {

    public List<Transaction> viewAllTransactionByType(String transactionType) throws TransactionException;
}
