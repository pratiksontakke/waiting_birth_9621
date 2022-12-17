package com.masai.service;

import com.masai.exception.BillPaymentException;
import com.masai.exception.LoginException;
import com.masai.model.BillPayment;

import java.util.Set;

public interface BillPaymentService {
    public BillPayment addBillPayment(String key, BillPayment billPayment) throws BillPaymentException, LoginException;

    public Set<BillPayment> viewAllBillPayment(String key) throws BillPaymentException, LoginException;
}
