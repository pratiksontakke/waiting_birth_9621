package com.masai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class BankAccount {

    @Id
    private Integer accountNo;
    private String ifscCode;
    private String bankName;
    private double balance;
    private Wallet wallet;

}
