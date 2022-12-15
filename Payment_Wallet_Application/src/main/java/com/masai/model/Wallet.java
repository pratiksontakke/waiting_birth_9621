package com.masai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer walledId;
    private Integer bigDecimal;

    @OneToMany(mappedBy = "wallet")
    @JsonIgnore
    private Set<Transaction> transactions = new HashSet<>();

    @JsonIgnore
    @OneToOne(mappedBy = "wallet", cascade = CascadeType.ALL)
    private Customer customer;


    @JsonIgnore
    @OneToMany(mappedBy = "wallet")
    private Set<BeneficiaryDetails> beneficiaryDetails = new HashSet<>();


    @JsonIgnore
    @OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL)
    private Set<BillPayment> billPayments = new HashSet<>();

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "wallet")
    private Set<BankAccount> bankAccounts = new HashSet<>();

}
