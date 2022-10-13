package com.example.usermanagement.service;

import com.example.usermanagement.dto.LoginDto;
import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.dto.UserPrivilegeDto;
import com.example.usermanagement.model.User;
import com.example.usermanagement.model.UserPrivilege;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Iuserservice {
    String insertRecord(UserDto addressDto);

    List<User> getall();

    String resetPassword(LoginDto loginDto);
    String forgotPassword(String email);
    User verifyUser(String token);
    User loginUser(LoginDto loginDTO);


    String editById(int id, UserDto userDto);

    int getAllUsersByAge();

    User changeCartQty(int userId, String profilePic);

    int getAllUsersbyLocation(String address);

    int getAllUsersbyGender(String gender);

    List<User> getRecentRegistrationList();

    List<User> getAllRegistrationList();

    UserPrivilege addpermission(UserPrivilegeDto userPrivilegeDto);

    int getAllUsersByAgeAbove40();

    int getAllUsersByAgeUnder18();
}