package com.masai.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BillPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer billId;

    private BillPaymentEnum billType;

//    @NotNull
    private double amount;

//    @NotNull
    private LocalDate paymentDate;

}
