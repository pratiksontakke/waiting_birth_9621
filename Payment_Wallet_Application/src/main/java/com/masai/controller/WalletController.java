package com.masai.controller;

import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;
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

    @GetMapping("/showBalance/{key}/{mob}")
    public ResponseEntity<Double> showBalanceHandler(@PathVariable("mob") String mob, @PathVariable("key") String key) throws CustomerException, LoginException {

        Double balance= walletService.showBalance(mob,key);

        return  new ResponseEntity<>(balance, HttpStatus.ACCEPTED);
    }



}
