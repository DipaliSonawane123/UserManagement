package com.example.usermanagement.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * User DTO class for add data of user as per requirement
 */
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


}

