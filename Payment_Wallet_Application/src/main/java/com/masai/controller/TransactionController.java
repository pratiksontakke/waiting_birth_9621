package com.masai.controller;

import com.masai.exception.*;
import com.masai.model.Transaction;
import com.masai.model.Wallet;
import com.masai.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Set;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/{key}")
    public ResponseEntity<Transaction> addTransaction(@PathVariable("key") String key, @RequestBody Transaction transaction) throws LoginException, TransactionException, BankAccountException, CustomerException {
        Transaction transaction1 = transactionService.addTransaction(key, transaction);
        return new ResponseEntity<Transaction>(transaction1, HttpStatus.CREATED);
    }

    @GetMapping("/{key}")
    public ResponseEntity<Set<Transaction>> viewAllTransactions(@PathVariable("key") String key) throws WalletException, LoginException, TransactionException {
        Set<Transaction> transactionSet = transactionService.viewAllTransactions(key);
        return new ResponseEntity<Set<Transaction>>(transactionSet, HttpStatus.OK);
    }

    @GetMapping("/{key}/{dateFrom}/{dateTo}")
    public ResponseEntity<Set<Transaction>> viewTransactionBetweenDates(@PathVariable("key") String key, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateFrom, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateTo) throws TransactionException, LoginException {
        Set<Transaction> transactionSet = transactionService.viewTransactionBetweenDates(key, dateFrom, dateTo);
        return new ResponseEntity<Set<Transaction>>(transactionSet, HttpStatus.OK);
    }

    @GetMapping("/{key}/{type}")
    public ResponseEntity<Set<Transaction>> viewAllTransactionByType(@PathVariable("key") String key, @PathVariable("type") String transactionType) throws TransactionException, LoginException {
        Set<Transaction> transactionSet = transactionService.viewAllTransactionByType(key, transactionType);
        return new ResponseEntity<Set<Transaction>>(transactionSet, HttpStatus.OK);
    }


}
