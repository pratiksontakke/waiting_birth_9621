package com.masai.controller;

import com.masai.exception.BankAccountException;
import com.masai.exception.LoginException;
import com.masai.model.BankAccount;
import com.masai.model.Transaction;
import com.masai.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/bankaccount")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @PostMapping("/{key}")
    public ResponseEntity<BankAccount> addBankAccount(@PathVariable("key") String key, @RequestBody BankAccount bankAccount) throws LoginException, BankAccountException {

        BankAccount bankAccount1 = bankAccountService.addAccount(key, bankAccount);

        return new ResponseEntity<BankAccount>(bankAccount1, HttpStatus.CREATED);
    }

    @DeleteMapping("/{key}/{accountnumber}")
    public ResponseEntity<BankAccount> deleteBankAccount(@PathVariable("key") String key, @PathVariable("accountnumber") Integer bankAccountNumber) throws LoginException, BankAccountException {

        BankAccount bankAccount1 = bankAccountService.removeAccount(key, bankAccountNumber);

        return new ResponseEntity<BankAccount>(bankAccount1, HttpStatus.OK);
    }

    @GetMapping("/{key}/{accountnumber}")
    public ResponseEntity<BankAccount> viewBankAccount(@PathVariable("key") String key, @PathVariable("accountnumber") Integer bankAccountNumber) throws LoginException, BankAccountException {

        BankAccount bankAccount1 = bankAccountService.viewAccount(key, bankAccountNumber);

        return new ResponseEntity<BankAccount>(bankAccount1, HttpStatus.OK);
    }

    @GetMapping("/{key}")
    public ResponseEntity<Set<BankAccount>> viewALLBankAccount(@PathVariable("key") String key) throws LoginException, BankAccountException {

        Set<BankAccount> bankAccounts = bankAccountService.viewAllBankAccounts(key);

        return new ResponseEntity<Set<BankAccount>>(bankAccounts, HttpStatus.OK);
    }

}
