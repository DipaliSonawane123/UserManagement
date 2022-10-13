package com.example.usermanagement.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor

public class UserDto {

    String firstName;
    String middleName;
    String lastName;
    int age;
    String profilePic;
    String gender;
    String contactNo;
    String emailId;
    String password;
    String address;
    String role;
    LocalDateTime createdTimeStamp = LocalDateTime.now();
    LocalDateTime updatedTimeStamp = LocalDateTime.now();
    boolean verified = false;
}

