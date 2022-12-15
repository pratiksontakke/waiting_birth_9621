package com.masai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
<<<<<<< HEAD

=======
>>>>>>> 8b1badcab112d2ca77296ee2b699cedb2ffe32bf
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer transactionId;
    private String transactionType;
    private LocalDate transactionDate;
    private double amount;
    private String description;
<<<<<<< HEAD

=======
>>>>>>> 8b1badcab112d2ca77296ee2b699cedb2ffe32bf
    @ManyToOne(cascade = CascadeType.ALL)
    private Wallet wallet;

}
