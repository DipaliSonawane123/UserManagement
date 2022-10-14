package com.example.usermanagement.service;

import com.example.usermanagement.dto.LoginDto;
import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.dto.UserPrivilegeDto;
import com.example.usermanagement.model.LoginHistory;
import com.example.usermanagement.model.User;
import com.example.usermanagement.model.UserPrivilege;

import java.util.List;

/**
 * Interface for extends userservice interface
 */
public interface Iuserservice {
    String insertRecord(UserDto addressDto);

    List<User> getAll();

    String resetPassword(LoginDto loginDto);

    String forgotPassword(String email);

    User verifyUser(String token);

    User loginUser(LoginDto loginDTO);


    String editById(int id, UserDto userDto);

    int getAllUsersByAgeBetween18to40();

    User changeProfilePic(int userId, String profilePic);

    int getAllUsersForLocation(String address);

    int getPercentageForGender(String gender);

    List<User> getRecentRegistrationList();

    List<User> getAllRegistrationList();

    UserPrivilege addPermission(UserPrivilegeDto userPrivilegeDto);

    int getAllUsersByAgeAbove40();

    int getAllUsersByAgeUnder18();

    List<LoginHistory> getLoginHistory(String email);

    User findUserById(int id);

    String findProfilePic(int id);

    User logout(int userId);
}