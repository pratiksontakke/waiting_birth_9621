package com.masai.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer accountNo;

//    @NotNull
//    @NotEmpty
//    @NotBlank
    private String ifscCode;

//    @NotBlank
//    @NotEmpty
//    @NotNull
    private String bankName;

//    @NotNull
    private double balance;


}
