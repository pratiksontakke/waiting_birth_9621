package com.masai.dao;

import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer> {
    public Customer findByMobileNumber(String mobileNo);
}
