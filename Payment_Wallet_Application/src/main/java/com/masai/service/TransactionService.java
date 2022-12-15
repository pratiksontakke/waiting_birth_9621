package com.masai.service;

import com.masai.exception.LoginException;
import com.masai.exception.TransactionException;
import com.masai.exception.WalletException;
import com.masai.model.Transaction;
import com.masai.model.Wallet;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface TransactionService {
    public Transaction addTransaction(String key, Transaction transaction) throws LoginException;

    public Set<Transaction> viewAllTransactions(String key) throws WalletException, LoginException, TransactionException;

    public Set<Transaction> viewTransactionBetweenDates(String key, LocalDate dateFrom, LocalDate dateTo) throws TransactionException, LoginException;

    public Set<Transaction> viewAllTransactionByType(String key, String transactionType) throws TransactionException, LoginException;
}
