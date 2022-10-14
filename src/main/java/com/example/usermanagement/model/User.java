package com.example.usermanagement.model;

import com.example.usermanagement.dto.LoginDto;
import com.example.usermanagement.dto.UserDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
public class User {

    //User Entities
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int userId;
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


    public User(UserDto userDTO) {
        this.firstName = userDTO.getFirstName();
        this.middleName = userDTO.getMiddleName();
        this.lastName = userDTO.getLastName();
        this.age = userDTO.getAge();
        this.profilePic = userDTO.getProfilePic();
        this.gender = userDTO.getGender();
        this.contactNo = userDTO.getContactNo();
        this.emailId = userDTO.getEmailId();
        this.password = userDTO.getPassword();
        this.address = userDTO.getAddress();
        this.role = userDTO.getRole();
        this.createdTimeStamp = userDTO.getCreatedTimeStamp();
        this.updatedTimeStamp = userDTO.getUpdatedTimeStamp();


    }

    public User(LoginDto logindto) {
        this.emailId = logindto.getEmail();
        this.password = logindto.getPassword();

    }
}

