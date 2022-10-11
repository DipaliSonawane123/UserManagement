package com.example.usermanagement.service;


import com.example.usermanagement.dto.LoginDto;
import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.model.User;

public interface Iuserservice {
    String insertRecord(UserDto addressDto);


    String resetPassword(LoginDto loginDto);

    String forgotPassword(String email);

    User verifyUser(String token);


    User loginUser(LoginDto loginDTO);
}