package com.masai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer accountNo;

    @NotNull
    @NotEmpty
    @NotBlank
    private String ifscCode;

    @NotBlank
    @NotEmpty
    @NotNull
    private String bankName;

    @NotNull
    private double balance;


    @ManyToOne
    @JoinColumn(name = "wallet_walled_id")
    private Wallet wallet;

}
