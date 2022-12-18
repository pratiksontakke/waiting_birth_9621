package com.masai.dao;

import com.masai.exception.BillPaymentException;
import com.masai.model.BankAccount;
import com.masai.model.BeneficiaryDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BeneficiaryDetailsDAO extends JpaRepository<BeneficiaryDetails, Integer> {
//    public void deleteByMobileNumber(Integer bId);
//
//    Optional<BeneficiaryDetails> findByMobileNumber(String mobileNumber);
//    public BeneficiaryDetails deleteByBId(Integer bid);


}
