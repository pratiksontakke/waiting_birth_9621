package com.masai.service;

import com.masai.dao.CustomerDAO;
import com.masai.dao.SessionDAO;
import com.masai.dao.TransactionDAO;
import com.masai.dao.WalletDAO;
import com.masai.exception.LoginException;
import com.masai.exception.TransactionException;
import com.masai.exception.WalletException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.Transaction;
import com.masai.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class TransactionServiceImpl implements TransactionService {

    /*
    *
    * Transaction service
1.	addTransaction -> call getCustomer, then getWallet then add the transaction to Set and save the transaction to wallet
2.	viewAllTransactions -> return set of transactions from wallet
3.	viewAllTransactions -> find the transaction b/w given two dates
4.	viewAllTransactionsByType -> return set of transactions from wallet    *
    * */

    @Autowired
    TransactionDAO transactionDAO;

    @Autowired
    WalletDAO walletDAO;

    @Autowired
    SessionDAO sessionDAO;

    @Autowired
    CustomerDAO customerDAO;

    public CurrentUserSession isLogin(String key) throws LoginException {
        CurrentUserSession currentUserSession = sessionDAO.findByUuid(key);
        if (currentUserSession != null)
            return currentUserSession;
        else
            return null;
    }

    @Override
    public Transaction addTransaction(String key, Transaction transaction) throws LoginException, TransactionException {
//        getting the wallet and adding the transactions

        CurrentUserSession aao = isLogin(key);

        if (aao != null) {
            Customer customer = customerDAO.findByMobileNumber(aao.getUserId());

            Wallet wallet = customer.getWallet();

            wallet.getTransactions().add(transaction);
            if(wallet.getBalance()>=transaction.getAmount()){
                wallet.setBalance(wallet.getBalance()-transaction.getAmount());
            }
            else{
                throw  new TransactionException("Insufficient Balance !!!");
            }
            walletDAO.save(wallet);
            transaction.setWallet(wallet);
            transactionDAO.save(transaction);
            return transaction;

        } else {
            throw new LoginException("You are not logged in ...");
        }
    }

    @Override
    public Set<Transaction> viewAllTransactions(String key) throws WalletException, LoginException, TransactionException {
//        to get all the transactions for a particular wallet

        CurrentUserSession aao = isLogin(key);

        if (aao != null) {
            Customer customer = customerDAO.findByMobileNumber(aao.getUserId());
            Set<Transaction> transactionSet = customer.getWallet().getTransactions();
            if (transactionSet.isEmpty()) {
                throw new TransactionException("No transactions found!");
            } else {
                return transactionSet;
            }
        } else {
            throw new LoginException("You are not logged in ...");
        }
    }

    @Override

    public Set<Transaction> viewTransactionBetweenDates(String key, LocalDate dateFrom, LocalDate dateTo) throws TransactionException, LoginException {

        CurrentUserSession aao = isLogin(key);

        Customer customer = customerDAO.findByMobileNumber(aao.getUserId());

        if (aao != null) {

            Wallet wallet = customer.getWallet();
            Set<Transaction> transactionSet = transactionDAO.findByTransactionDateBetween(dateFrom, dateTo);
            System.out.println(transactionSet);
            Set<Transaction> transactionSet2 = new HashSet<>();

            for (Transaction t : transactionSet) {
                System.out.println("boom boom");
                if (t.getWallet()!=null && t.getWallet().getWalledId() == wallet.getWalledId()) {

                    System.out.println(t.getWallet().getWalledId()  + " " +wallet.getWalledId());
                    transactionSet2.add(t);
                }
            }
            if (transactionSet2.isEmpty()) {
                throw new TransactionException("No transactions found!");
            } else {
                return transactionSet2;
            }

        } else {
            throw new LoginException("You are not logged in!");
        }
    }


    @Override
    public Set<Transaction> viewAllTransactionByType(String key, String transactionType) throws TransactionException, LoginException {

        CurrentUserSession aao = isLogin(key);

        Customer customer = customerDAO.findByMobileNumber(aao.getUserId());

        if (aao != null) {
            System.out.println("before wallet");
            Wallet wallet = customer.getWallet();
            System.out.println("after wallet");
            Set<Transaction> transactionSet = wallet.getTransactions();
            Set<Transaction> transactionSet2 = new HashSet<>();

            for (Transaction t : transactionSet) {
                if (t.getTransactionType().equals(transactionType)) {
                    transactionSet2.add(t);
                }
            }
            if (transactionSet2.isEmpty()) {
                throw new TransactionException("No transactions found!");
            } else {
                return transactionSet2;
            }

        } else {
            throw new LoginException("You are not logged in!");
        }
    }
}