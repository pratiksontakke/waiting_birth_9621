package com.masai.service;

import com.masai.dao.BankAccountDAO;
import com.masai.dao.CustomerDAO;
import com.masai.dao.WalletDAO;
import com.masai.exception.CustomerException;
import com.masai.model.BankAccount;
import com.masai.model.Customer;
import com.masai.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BankAccountServiceImpl implements  BankAccountService{

    @Autowired
    private WalletDAO walletDAO;

    @Autowired
    private CustomerDAO customerDAO;

}
