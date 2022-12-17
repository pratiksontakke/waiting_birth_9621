package com.masai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BeneficiaryDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bId;
    //
//    @NotNull
//    @NotBlank
//    @NotEmpty
    private String name;

//    @NotNull
//    @NotBlank
//    @NotEmpty
//    @Pattern(regexp = "^([+]\\d{2}[ ])?\\d{10}$\n")

    private String mobileNumber;

//    ^([+]\d{2}[ ])?\d{10}$ == +91 9876543210 this is the pattern

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Wallet wallet;

}
