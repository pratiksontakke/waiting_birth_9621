package com.masai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer transactionId;

    @NotNull
    private TransactionTypeEnum transactionTypeEnum;
    @NotNull
    private LocalDate transactionDate;
    @NotNull
    private double amount;

    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    private Wallet wallet;

}
