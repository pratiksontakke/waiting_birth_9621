package com.masai.service;

import com.masai.dao.CustomerDAO;
import com.masai.dao.SessionDAO;
import com.masai.dao.WalletDAO;
import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletDAO walletDAO;

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private SessionDAO sessionDAO;

    public CurrentUserSession isLogin(String key) throws LoginException {
        CurrentUserSession currentUserSession = sessionDAO.findByUuid(key);
        if (currentUserSession != null)
            return currentUserSession;
        else
            return  null;
    }

    @Override
    public double showBalance(String mobileNumber, String key) throws CustomerException, LoginException {

        if (isLogin(key)!=null) {
            Customer customer = customerDAO.findByMobileNumber(mobileNumber);


            if (customer != null)
                return customer.getWallet().getBalance();
            else
                throw new CustomerException("No Account found with id :" + mobileNumber);
        } else {
            throw new LoginException("You are not logged in ...");
        }


    }

    @Override
    public Customer getCustomers(String key) throws CustomerException, LoginException {

        CurrentUserSession aao = isLogin(key);
        if (aao!=null) {
            Optional<Wallet> customer = walletDAO.findById(aao.getUserId());

            return  customer.get().getCustomer();
        } else {
            throw new LoginException("You are not logged in ...");
        }
    }
}
