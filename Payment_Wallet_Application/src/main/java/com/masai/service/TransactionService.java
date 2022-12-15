package com.masai.service;

import com.masai.exception.TransactionException;
import com.masai.exception.WalletException;
import com.masai.model.Transaction;
import com.masai.model.Wallet;

import java.time.LocalDate;
import java.util.List;

public interface TransactionService {
    public Transaction addTransaction(Transaction transaction);

    public List<Transaction> viewAllTransactions(Wallet wallet) throws WalletException;

    public List<Transaction> viewTransactionBetweenDates(LocalDate dateFrom, LocalDate dateTo) throws TransactionException;

//    public List<Transaction> viewAllTransactionByType(String transactionType) throws TransactionException;
}
