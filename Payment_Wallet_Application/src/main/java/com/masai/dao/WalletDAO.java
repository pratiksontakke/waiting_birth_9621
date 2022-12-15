package com.masai.dao;

import com.masai.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletDAO extends JpaRepository<Wallet, Integer> {

}
