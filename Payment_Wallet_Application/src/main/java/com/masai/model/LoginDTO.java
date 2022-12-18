package com.masai.model;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class LoginDTO {
    @NotNull
    @NotBlank
    @NotEmpty
    private String mobileNumber;
    @NotNull
    @NotBlank
    @NotEmpty
    private String password;

}
