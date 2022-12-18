package com.masai.dao;

import com.masai.exception.BankAccountException;
import com.masai.exception.LoginException;
import com.masai.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountDAO extends JpaRepository<BankAccount, Integer> {
    public BankAccount findByAccountNo(Integer accounNo) throws BankAccountException, LoginException;

}
