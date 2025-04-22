package com.expense.expensetracker.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {
    @NotBlank(message = "Username is required")
    @Size(max = 100, message = "dai lusu..")
    private String username;

    @NotBlank(message = "Email is required")
    @Email(message = "not valid Email")
    private String email;

    @NotBlank(message = "Password")
    @Size(min = 6, max = 50, message = "passwords atleast 6 characters")
    private String password;
}
