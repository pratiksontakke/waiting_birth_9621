package com.masai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeneficiaryDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bId;

    @NotNull
    @NotBlank
    @NotEmpty
    private String name;

    @NotNull
    @NotBlank
    @NotEmpty
    @Pattern(regexp = "^([+]\\d{2}[ ])?\\d{10}$\n")
    private String mobileNumber;

//    ^([+]\d{2}[ ])?\d{10}$ == +91 9876543210 this is the pattern

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Wallet wallet;

}
