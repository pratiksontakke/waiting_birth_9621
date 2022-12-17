package com.masai.controller;

import com.masai.exception.BillPaymentException;
import com.masai.exception.LoginException;
import com.masai.exception.TransactionException;
import com.masai.exception.WalletException;
import com.masai.model.BillPayment;
import com.masai.model.Transaction;
import com.masai.service.BillPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/billPayments")
public class BillPaymentController {

    @Autowired
    private BillPaymentService billPaymentService;


    @PostMapping("/add/{key}")
    public ResponseEntity<BillPayment> addBillPayment(@PathVariable("key") String key, @RequestBody BillPayment billPayment) throws LoginException, BillPaymentException {


        BillPayment billPayment1 = billPaymentService.addBillPayment(key, billPayment);

        return new ResponseEntity<BillPayment>(billPayment1, HttpStatus.CREATED);
    }

    @GetMapping("/{key}")
    public ResponseEntity<Set<BillPayment>> viewAllBillPayments(@PathVariable("key") String key) throws LoginException, BillPaymentException {

        Set<BillPayment> billPaymentSet = billPaymentService.viewAllBillPayment(key);

        return new ResponseEntity<Set<BillPayment>>(billPaymentSet, HttpStatus.OK);
    }
}
