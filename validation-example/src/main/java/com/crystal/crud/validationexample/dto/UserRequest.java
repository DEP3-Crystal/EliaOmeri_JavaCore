package com.crystal.crud.validationexample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")

public class UserRequest {
    @NotNull(message = "user's name shouldn't be null")
    private String name;
    @Email(message = "Invalid email address")
    private String email;
    @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number")
    private String mobile;
    private String gender;
    @Min(18)
    @Max(60)
    private int age;
    @NotBlank
    private String nationality;
}
