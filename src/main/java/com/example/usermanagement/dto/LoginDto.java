package com.example.usermanagement.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
public class LoginDto {
    String email;
    @NotEmpty(message = "Address Cannot be Empty")
//    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&*()-+=])([a-zA-Z0-9@._-]).{8,}$", message = "Invalid Password\n(1. Upper case character that must occur at least once.\n" +
//            "2. A digit must occur at least once.\n3. Special symbol at least once.\n4. lower case character or number must occur at least once.\n5. Represents at least 8 or more characters.)")
    String password;
}

