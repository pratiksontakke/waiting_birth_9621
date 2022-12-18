package com.masai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer transactionId;

//    @NotNull
    private String transactionType;

//    @NotNull
    private LocalDate transactionDate;
//    @NotNull
    private double amount;

    private String description;

    @JsonIgnore
    @ManyToOne
    private Wallet wallet;

}
