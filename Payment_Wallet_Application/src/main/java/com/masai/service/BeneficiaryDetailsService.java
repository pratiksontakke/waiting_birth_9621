package com.masai.service;

import com.masai.exception.BeneficiaryDetailsException;
import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;
import com.masai.model.BeneficiaryDetails;

import java.util.List;
import java.util.Set;

public interface BeneficiaryDetailsService {
    public BeneficiaryDetails addBeneficiaryDetails(String key ,BeneficiaryDetails Bd) throws CustomerException , LoginException;

    public BeneficiaryDetails deleteBeneficiaryDetails(String key, Integer Bid ) throws CustomerException ,LoginException,BeneficiaryDetailsException;

    public BeneficiaryDetails getBeneficiaryDetailsById(String key,Integer Bid ) throws CustomerException ,LoginException,BeneficiaryDetailsException;

    public Set<BeneficiaryDetails> getAllBeneficiaryDetails(String key) throws CustomerException ,LoginException,BeneficiaryDetailsException;


}
