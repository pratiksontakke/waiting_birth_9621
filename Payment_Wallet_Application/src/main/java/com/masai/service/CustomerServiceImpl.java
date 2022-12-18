package com.masai.service;

import com.masai.dao.CustomerDAO;
import com.masai.dao.SessionDAO;
import com.masai.dao.WalletDAO;
import com.masai.exception.CustomerException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO cDao;

    @Autowired
    private SessionDAO sDao;
    @Autowired
    private WalletDAO wDao;


    @Override
    public Customer createCustomer(Customer customer) throws CustomerException {
        Customer existingCustomer = cDao.findByMobileNumber(customer.getMobileNumber());
        if (existingCustomer != null)
            throw new CustomerException("Customer Already Registered with Mobile number");
        Wallet wallet = new Wallet();
        wallet.setBalance(0.0);
        wallet.setCustomer(customer);
        customer.setWallet(wallet);
        return cDao.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer, String key) throws CustomerException {
        CurrentUserSession loggedInUser = sDao.findByUuid(key);
        if (loggedInUser == null) {
            throw new CustomerException("Please provide a valid key to update a customer");
        } else {
            Customer customer1 = cDao.findByMobileNumber(loggedInUser.getUserId());
            if (Objects.equals(customer1.getCustomerId(), customer.getCustomerId())) {
                customer1.setName(customer.getName());
                customer1.setEmail(customer.getEmail());
                customer1.setPassword(customer.getPassword());
                customer1.setMobileNumber(customer.getMobileNumber());
                loggedInUser.setUserId(customer.getMobileNumber());
                return cDao.save(customer1);
            } else {
                throw new CustomerException("Invalid Customer Details, please login first");
            }
        }
    }


}


