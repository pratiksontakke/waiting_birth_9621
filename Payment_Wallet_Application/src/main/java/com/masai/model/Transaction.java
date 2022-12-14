package com.masai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private Integer transactionId;
    private String transactionType;
    private LocalDate transactionDate;
    private double amount;
    private String description;

    private Wallet wallet;

}
