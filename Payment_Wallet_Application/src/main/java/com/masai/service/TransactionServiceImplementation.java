package com.masai.service;

import com.masai.dao.TransactionDAO;
import com.masai.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class TransactionServiceImplementation implements TransactionService {
    @Autowired
    TransactionDAO transactionDAO;

    @Override
    public Transaction addTransaction(Transaction transaction) {
        Transaction t = transactionDAO.save(transaction);
        return t;
    }

    @Override
    public List<Transaction> viewTransactionBetweenDates(LocalDate dateFrom, LocalDate dateTo) {
        List<Transaction> list;
        return null;
    }

    @Override
    public List<Transaction> viewAllTransactionByType(String transactionType) {
        return null;
    }
}
