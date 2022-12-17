package com.masai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer walledId;
    private Double balance;

    @OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Transaction> transactions = new HashSet<>();

    @JsonIgnore
    @OneToOne(mappedBy = "wallet", cascade = CascadeType.ALL)
    private Customer customer;


    @JsonIgnore
    @OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<BeneficiaryDetails> beneficiaryDetails = new HashSet<>();


    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private Set<BillPayment> billPayments = new HashSet<>();

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private Set<BankAccount> bankAccounts = new HashSet<>();

}
