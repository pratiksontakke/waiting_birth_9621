package com.masai.dao;

import com.masai.model.BankAccount;
import com.masai.model.BeneficiaryDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiaryDetailsDAO extends JpaRepository<BeneficiaryDetails, Integer> {
}
