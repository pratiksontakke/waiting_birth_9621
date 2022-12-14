package com.masai.service;

import com.masai.dao.TransactionDAO;
import com.masai.dao.WalletDAO;
import com.masai.exception.TransactionException;
import com.masai.model.Transaction;
import com.masai.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class TransactionServiceImplementation implements TransactionService {
    @Autowired
    TransactionDAO transactionDAO;

    @Autowired
    WalletDAO walletDAO;

    @Override
    public Transaction addTransaction(Transaction transaction) {
        Transaction t = transactionDAO.save(transaction);
        return t;
    }

    @Override
    public Transaction viewAllTransactions(Wallet wallet) {

        return null;
    }

    @Override
    public List<Transaction> viewTransactionBetweenDates(LocalDate dateFrom, LocalDate dateTo) throws TransactionException {
        List<Transaction> list = transactionDAO.findAll();
        if (list.size() == 0) {
            throw new TransactionException("No transaction found in between given dates");
        }
        return list;
    }


    public List<Transaction> viewAllTransactionByType(String transactionType) throws TransactionException {
        List<Transaction> list = transactionDAO.findAll();
        if (list.size() == 0) {
            throw new TransactionException("No transaction found in between given dates");
        }
        return list;
    }
}
