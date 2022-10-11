package com.example.usermanagement.controller;


import com.example.usermanagement.dto.LoginDto;
import com.example.usermanagement.dto.ResponseDto;
import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.model.User;
import com.example.usermanagement.service.Iuserservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
    @RequestMapping("/user")
    public class UserController {
    @Autowired
    Iuserservice service;

    /**
     * Post Api for insert user data
     */
    @PostMapping("/insert")
    public ResponseEntity<ResponseDto> AddUserDetails(@RequestBody UserDto userDto) {
        String token = service.insertRecord(userDto);
        ResponseDto respDTO = new ResponseDto("*** User Added successfully ***", token);
        return new ResponseEntity(respDTO, HttpStatus.CREATED);
    }
    /**
     * Post Api for Login for particular user
     */
    @PostMapping("/login")
    public ResponseEntity<ResponseDto> loginUser(@RequestBody LoginDto loginDTO) {
        User response = service.loginUser(loginDTO);
        ResponseDto responseDTO = new ResponseDto("Login Successful!", response);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    /**
     * Get Api for Forgot password with email*/
    @GetMapping("/forgotpassword/{email}")
    public ResponseEntity<ResponseDto> forgotPasswordByemail(@PathVariable String email) {
        String response = service.forgotPassword(email);
        ResponseDto respDTO = new ResponseDto("*** Link send successfully ***", response);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }
    /**
     * Post Api for resetPassword user data
     */
    @PostMapping("/resetPassword")
    public ResponseEntity<String> resetPassword(@RequestBody LoginDto loginDto) {
        String response = service.resetPassword(loginDto);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("/verify/{token}")
    public ResponseEntity<ResponseDto> verifyUser(@PathVariable String token){
        User response = service.verifyUser(token);
        ResponseDto responseDTO = new ResponseDto("User verified successfully", response );
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}