package com.masai.controller;

import com.masai.exception.BankAccountException;
import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;
import com.masai.exception.TransactionException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;
    @GetMapping("/{key}/{mob}")
    public ResponseEntity<Double> showBalanceHandler(@PathVariable("key") String key, @PathVariable("mob") String mob) throws CustomerException, LoginException {
        Double balance= walletService.showBalance(key,mob);
        return new ResponseEntity<>(balance, HttpStatus.OK);
    }

    @GetMapping("/{key}")
    public ResponseEntity<Customer> getCustomersHandler(@PathVariable("key") String key) throws CustomerException, LoginException {
        Customer customer = walletService.getCustomers(key);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PutMapping("/{key}/{amount}")
    public ResponseEntity<String> depositAmountHandler(@PathVariable("key") String key, @PathVariable("amount") Double amount) throws CustomerException, LoginException {
        String msg = walletService.depositAmount(key,amount);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Customer> fundTransferHandler(@RequestParam("srcMob") String srcMob, @RequestParam("desMob") String desMob, @RequestParam("amount") Double amount, @RequestParam("key")String key) throws CustomerException, LoginException, BankAccountException, TransactionException {
        Customer customer = walletService.fundTransfer(srcMob,desMob,amount,key);
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

}
