package com.example.usermanagement.controller;
/**
 * Controller for Api of user management project
 **/

import com.example.usermanagement.dto.LoginDto;
import com.example.usermanagement.dto.ResponseDto;
import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.dto.UserPrivilegeDto;
import com.example.usermanagement.model.LoginHistory;
import com.example.usermanagement.model.User;
import com.example.usermanagement.model.UserPrivilege;
import com.example.usermanagement.service.Iuserservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")//global access for user management project
public class UserController {
    @Autowired
    Iuserservice service;//dependency injection of interface of service

    /**
     * Post Api for insert user data
     */
    @PostMapping("/insert")
    public ResponseEntity<ResponseDto> AddUserDetails(@RequestBody UserDto userDto) {
        String token = service.insertRecord(userDto);
        ResponseDto respDTO = new ResponseDto("*** User Added successfully...✅ ***", token);
        return new ResponseEntity(respDTO, HttpStatus.CREATED);
    }

    /**
     * GET Api for get all user details by id
     */
    @GetMapping("/getbyid/{Id}")
    public ResponseEntity<ResponseDto> findUserById(@PathVariable int Id) {
        User response = service.findUserById(Id);
        ResponseDto responseDto = new ResponseDto("*** All Details of user's on this id using Id ***", response);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    /**
     * GET Api for find user profile-pic by id
     */
    @GetMapping("/getprofile/{Id}")
    public ResponseEntity<ResponseDto> FindProfilePic(@PathVariable int Id) {
        String response = service.findProfilePic(Id);
        ResponseDto responseDto = new ResponseDto("*** Profile picture of user  on this id using Id ***", response);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    /**
     * POST Api for Login for particular user
     */
    @PostMapping("/login")
    public ResponseEntity<ResponseDto> loginUser(@RequestBody LoginDto loginDTO) {
        User response = service.loginUser(loginDTO);
        ResponseDto responseDTO = new ResponseDto("Login Successful..!✅", response);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * GET Api for Forgot password with email
     */
    @GetMapping("/forgotpassword/{email}")
    public ResponseEntity<ResponseDto> forgotPasswordByEmail(@PathVariable String email) {
        String response = service.forgotPassword(email);
        ResponseDto respDTO = new ResponseDto("*** Link send successfully..!✅ ***", response);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    /**
     * POST Api for resetPassword user data
     */
    @PostMapping("/resetPassword/{password}")
    public ResponseEntity<String> resetPassword(@RequestParam LoginDto loginDto) {
        String response = service.resetPassword(loginDto);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    /**
     * GET Api for Verify user
     */
    @GetMapping("/verify/{token}")
    public ResponseEntity<ResponseDto> verifyUser(@PathVariable String token) {
        User response = service.verifyUser(token);
        ResponseDto responseDTO = new ResponseDto("User verified successfully", response);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * GET Api for geting All user
     */
    @GetMapping("/getall")
    public ResponseEntity<ResponseDto> GetAllDetails() {
        List<User> response = service.getAll();
        ResponseDto responseDto = new ResponseDto(" All  user's List ", response);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    /**
     * PUT Api for update user information by id
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDto> editData(@PathVariable int id, @Valid @RequestBody UserDto userDto) {
        String response = service.editById(id, userDto);
        ResponseDto responseDTO = new ResponseDto("Updated user Details Successfully..!✅", response);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * GET Api for get  group of particular Age under18
     */
    @GetMapping("/getGroupByAge-under18")
    public ResponseEntity<ResponseDto> getAllUsersByAgeUnder18() {
        int newUser = service.getAllUsersByAgeUnder18();
        ResponseDto responseDTO = new ResponseDto("All Users Age records retrieved successfully !", newUser);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    /**
     * GET Api for get  group of particular Age between 18 and 40
     */
    @GetMapping("/getGroupByAge-18to40")
    public ResponseEntity<ResponseDto> getAllUsersByAge() {
        int newUser = service.getAllUsersByAge();
        ResponseDto responseDTO = new ResponseDto("All Users Age records retrieved successfully !", newUser);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    /**
     * GET Api for get group of particular Age above 40
     */
    @GetMapping("/getGroupByAge-above40")
    public ResponseEntity<ResponseDto> getAllUsersByAgeAbove40() {
        int newUser = service.getAllUsersByAgeAbove40();
        ResponseDto responseDTO = new ResponseDto("All Users Age records retrieved successfully !", newUser);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    /**
     * PUT Api for update only profile pic
     */
    @PutMapping("/update-profilePic")
    public ResponseEntity<ResponseDto> changeProfilePic(@RequestParam int userId, @RequestParam String profilePic) {
        User user = service.changeProfilePic(userId, profilePic);
        ResponseDto responseDTO = new ResponseDto("Profile picture changed successfully", user);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * GET Api for get user list for particular location
     */
    @GetMapping("/get/{address}")
    public ResponseEntity<ResponseDto> getUserByLocation(@PathVariable String address) {
        int newUser = service.getAllUsersForLocation(address);
        ResponseDto responseDTO = new ResponseDto("Data by using Location!", newUser);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    /**
     * GET Api for get percentage for particular age
     */
    @GetMapping("/get-gender/{gender}")
    public ResponseEntity<ResponseDto> getUserByGender(@PathVariable String gender) {
        int newUser = service.getPercentageForGender(gender);
        ResponseDto responseDTO = new ResponseDto("Particular gender percentage....", newUser + "%");
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    /**
     * GET Api for get recent registration
     */
    @GetMapping(value = "/recent-registration")
    public ResponseEntity<ResponseDto> getLatestRegistration() {
        List<User> newUser = service.getRecentRegistrationList();
        ResponseDto responseDTO = new ResponseDto("Recent Registration....", newUser);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    /**
     * GET Api for get all registration
     */
    @GetMapping(value = "/all-registration")
    public ResponseEntity<ResponseDto> getALLRegistration() {
        List<User> newUser = service.getAllRegistrationList();
        ResponseDto responseDTO = new ResponseDto("All Registration....", newUser);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    /**
     * Post Api for get add permission
     */
    @PostMapping("/add-permission")
    public ResponseEntity<ResponseDto> addBook(@Valid @RequestBody UserPrivilegeDto userPrivilegeDto) {
        UserPrivilege permission = service.addPermission(userPrivilegeDto);
        ResponseDto responseDTO = new ResponseDto("Add permission for particular user", permission);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * GET Api for get all login  time history
     */
    @GetMapping(value = "/login-history/{email}")
    public ResponseEntity<ResponseDto> getLatestRegistration(@PathVariable String email) {
        List<LoginHistory> loginHistory = service.getLoginHistory(email);
        ResponseDto responseDTO = new ResponseDto("Recent Registration....", loginHistory);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }
}