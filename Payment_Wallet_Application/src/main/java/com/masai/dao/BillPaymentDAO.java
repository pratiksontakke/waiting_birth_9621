package com.masai.dao;

import com.masai.model.BillPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillPaymentDAO extends JpaRepository<BillPayment, Integer> {
}
