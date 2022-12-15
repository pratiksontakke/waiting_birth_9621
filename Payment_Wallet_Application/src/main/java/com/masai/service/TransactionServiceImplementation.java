package com.masai.service;

import com.masai.dao.TransactionDAO;
import com.masai.dao.WalletDAO;
import com.masai.exception.TransactionException;
import com.masai.exception.WalletException;
import com.masai.model.Transaction;
import com.masai.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TransactionServiceImplementation implements TransactionService {
    @Autowired
    TransactionDAO transactionDAO;

    @Autowired
    WalletDAO walletDAO;

    @Override
    public Transaction addTransaction(Transaction transaction) {
//        getting the wallet and adding the transactions
        Wallet wallet = transaction.getWallet();
        wallet.getTransactions().add(transaction);
        walletDAO.save(wallet);
        transactionDAO.save(transaction);
        return null;
    }

    @Override
    public List<Transaction> viewAllTransactions(Wallet wallet) throws WalletException {
//        to get all the transactions for a particular wallet

        Integer id = wallet.getWalledId();
        Set<Transaction> transactionsSet;
        Optional<Wallet> w = walletDAO.findById(id);

        if (w.isEmpty()) {
            throw new WalletException("No wallet found with given id");
        } else {
            transactionsSet = w.get().getTransactions();
        }

        List<Transaction> transactionsList = new ArrayList<>(transactionsSet);

        return transactionsList;
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
