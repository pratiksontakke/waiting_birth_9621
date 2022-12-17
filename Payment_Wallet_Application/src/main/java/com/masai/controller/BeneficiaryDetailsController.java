package com.masai.controller;

import com.masai.exception.BeneficiaryDetailsException;
import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;
import com.masai.model.BeneficiaryDetails;
import com.masai.model.Transaction;
import com.masai.service.BeneficiaryDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/BeneficiaryDetails")
public class BeneficiaryDetailsController {


    @Autowired
    private BeneficiaryDetailsService beneficiaryDetailsService;

    @PostMapping("/{key}")
    public ResponseEntity<BeneficiaryDetails> addBeneficiaryDetail(@PathVariable("key") String key, @RequestBody BeneficiaryDetails beneficiaryDetails) throws LoginException, CustomerException {

        BeneficiaryDetails beneficiaryDetails1 = beneficiaryDetailsService.addBeneficiaryDetails(key , beneficiaryDetails);

        return new ResponseEntity<BeneficiaryDetails>(beneficiaryDetails1, HttpStatus.CREATED);
    }



    @DeleteMapping("/{key}/{Bid}")
    public ResponseEntity<BeneficiaryDetails> deleteBeneficiaryDetail(@PathVariable("key") String key , @PathVariable("Bid") Integer Bid ) throws LoginException, CustomerException, BeneficiaryDetailsException {

        BeneficiaryDetails beneficiaryDetails1 = beneficiaryDetailsService.deleteBeneficiaryDetails(  key , Bid);

        return new ResponseEntity<BeneficiaryDetails>(beneficiaryDetails1, HttpStatus.OK);
    }


    @GetMapping ("/{key}/{Bid}")
    public ResponseEntity<BeneficiaryDetails> getBeneficiaryDetail(@PathVariable("key") String key , @PathVariable("Bid") Integer Bid ) throws LoginException, CustomerException, BeneficiaryDetailsException {

        BeneficiaryDetails beneficiaryDetails1 = beneficiaryDetailsService.getBeneficiaryDetailsById(key,Bid);

        return new ResponseEntity<BeneficiaryDetails>(beneficiaryDetails1, HttpStatus.OK);
    }


    @GetMapping ("/{key}")
    public ResponseEntity<Set<BeneficiaryDetails>> getAllBeneficiary(@PathVariable("key") String key ) throws LoginException, CustomerException, BeneficiaryDetailsException {

        Set<BeneficiaryDetails> allbeneficiaryDetails = beneficiaryDetailsService.getAllBeneficiaryDetails(key);

        return new ResponseEntity<Set<BeneficiaryDetails>>(allbeneficiaryDetails, HttpStatus.OK);
    }

}
