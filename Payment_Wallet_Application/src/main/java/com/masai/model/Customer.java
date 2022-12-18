package com.masai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;

    @NotNull
    @NotBlank
    @NotEmpty
    private String name;


    @Size(min = 10, message = "Please enter valid mobile number")
    @Column(unique=true)
    private String mobileNumber;

    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}", message = "Password must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters")
    private String password;

    @Email(message = "Enter valid email id.")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Wallet wallet;

}
