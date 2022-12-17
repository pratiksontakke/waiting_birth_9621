package com.masai.service;

import com.masai.dao.BankAccountDAO;
import com.masai.dao.CustomerDAO;
import com.masai.dao.SessionDAO;
import com.masai.dao.WalletDAO;
import com.masai.exception.BankAccountException;
import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;
import com.masai.model.BankAccount;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private WalletDAO walletDAO;

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private SessionDAO sessionDAO;

    @Autowired
    private BankAccountDAO bankAccountDAO;

    public CurrentUserSession isLogin(String key) throws LoginException {
        CurrentUserSession currentUserSession = sessionDAO.findByUuid(key);
        if (currentUserSession != null)
            return currentUserSession;
        else
            return null;
    }


    @Override
    public BankAccount addAccount(String key, BankAccount bankAccount) throws BankAccountException, LoginException {

        CurrentUserSession aao = isLogin(key);

        if (aao != null) {
            Customer customer = customerDAO.findByMobileNumber(aao.getUserId());

            Wallet wallet = customer.getWallet();

            wallet.getBankAccounts().add(bankAccount);
            walletDAO.save(wallet);

            return bankAccount;

        } else {
            throw new LoginException("You are not logged in ...");
        }

    }

    @Override
    public BankAccount removeAccount(String key, Integer bankAccountNumber) throws BankAccountException, LoginException {

        CurrentUserSession aao = isLogin(key);

        if (aao != null) {
            Customer customer = customerDAO.findByMobileNumber(aao.getUserId());

            Wallet wallet = customer.getWallet();

            Optional<BankAccount> bankAccount = bankAccountDAO.findById(bankAccountNumber);
            if (bankAccount.isPresent()) {
                bankAccountDAO.delete(bankAccount.get());
                return bankAccount.get();

            } else {
                throw new BankAccountException("No bank account found!");
            }

        } else {
            throw new LoginException("You are not logged in ...");
        }

    }

    @Override
    public BankAccount viewAccount(String key, Integer bankAccountNumber) throws BankAccountException, LoginException {

        CurrentUserSession aao = isLogin(key);

        if (aao != null) {

            Optional<BankAccount> bankAccount = bankAccountDAO.findById(bankAccountNumber);
            if (bankAccount.isPresent()) {

                return bankAccount.get();

            } else {
                throw new BankAccountException("No bank account found!");
            }

        } else {
            throw new LoginException("You are not logged in ...");
        }
    }

    @Override
    public Set<BankAccount> viewAllBankAccounts(String key) throws BankAccountException, LoginException {

        CurrentUserSession aao = isLogin(key);

        if (aao != null) {

            Customer customer = customerDAO.findByMobileNumber(aao.getUserId());

            Set<BankAccount> bankAccounts = customer.getWallet().getBankAccounts();
            if (bankAccounts.size()!=0) {

                return bankAccounts;

            } else {
                throw new BankAccountException("No bank account found!");
            }

        } else {
            throw new LoginException("You are not logged in ...");
        }
    }
}
