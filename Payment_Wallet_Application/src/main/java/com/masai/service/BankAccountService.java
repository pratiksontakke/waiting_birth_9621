package com.masai.service;

import com.masai.exception.BankAccountException;
import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;
import com.masai.exception.WalletException;
import com.masai.model.BankAccount;
import com.masai.model.Customer;
import com.masai.model.Wallet;

import java.util.List;
import java.util.Set;

public interface BankAccountService {


    public BankAccount addAccount(String key, BankAccount bankAccount) throws BankAccountException, LoginException;

    public BankAccount removeAccount(String key, Integer bankAccountNumber) throws BankAccountException, LoginException;

    public BankAccount viewAccount(String key, Integer bankAccountNumber) throws BankAccountException, LoginException;

    public Set<BankAccount> viewAllBankAccounts(String key) throws BankAccountException, LoginException;

}
