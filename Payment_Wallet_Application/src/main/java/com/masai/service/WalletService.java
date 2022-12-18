package com.masai.service;


import com.masai.exception.BankAccountException;
import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;

import com.masai.exception.TransactionException;
import com.masai.model.Customer;
import com.masai.model.Wallet;

import java.math.BigDecimal;
import java.util.List;


public interface WalletService {

    //public Customer createWalletAccount(String name,String mobileNumber, double balance) throws CustomerException, WalletException;
    public double showBalance(String mobileNumber) throws CustomerException, LoginException ;


    public Customer getCustomers(String key) throws CustomerException, LoginException;
    public String depositAmount(String key, Double amount ) throws CustomerException, LoginException;


    public Customer fundTransfer(String desMob, Double amount,String key) throws CustomerException, LoginException, BankAccountException, TransactionException;

    public Customer creditedFund(String desMob, Double amount) throws CustomerException, LoginException, BankAccountException, TransactionException;
}
