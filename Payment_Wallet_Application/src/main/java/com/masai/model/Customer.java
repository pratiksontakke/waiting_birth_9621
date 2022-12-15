package com.masai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;

    @NotEmpty
    @NotBlank
    @NotNull
    @Pattern(regexp = "[A-Za-z]")
    private String name;


    @Size(min = 10, message = "Please enter valid mobile number")
    private String mobileNumber;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,15}$\n")
    private String password;

    @Email
    private String email;

    @OneToOne
    private Wallet wallet;

}
