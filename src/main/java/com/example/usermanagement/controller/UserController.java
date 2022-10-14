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
        ResponseDto responseDto = new ResponseDto("*** All Details of  User's  on this id using Id ***", response);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    /**
     * GET Api for find user profile-pic by id
     */
    @GetMapping("/getprofile/{Id}")
    public ResponseEntity<ResponseDto> FindProfilePic(@PathVariable int Id) {
        String response = service.findProfilePic(Id);
        ResponseDto responseDto = new ResponseDto("*** Profile picture of user  on this id using Id***", response);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    /**
     * POST Api for Login for particular user
     */
    @PostMapping("/login")
    public ResponseEntity<ResponseDto> loginUser(@RequestBody LoginDto loginDTO ) {
        User response = service.loginUser(loginDTO);
        ResponseDto responseDTO = new ResponseDto("Login Successful..!✅!", response);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Get Api for Forgot password with email
     */
    @GetMapping("/forgotpassword/{email}")
    public ResponseEntity<ResponseDto> forgotPasswordByemail(@PathVariable String email) {
        String response = service.forgotPassword(email);
        ResponseDto respDTO = new ResponseDto("*** Link send successfully ***", response);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    /**
     * Post Api for resetPassword user data
     */
    @PostMapping("/resetPassword/{password}")
    public ResponseEntity<String> resetPassword(@RequestParam LoginDto loginDto) {
        String response = service.resetPassword(loginDto);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("/verify/{token}")
    public ResponseEntity<ResponseDto> verifyUser(@PathVariable String token) {
        User response = service.verifyUser(token);
        ResponseDto responseDTO = new ResponseDto("User verified successfully", response);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Get Api for geting All user
     */
    @GetMapping("/getall")
    public ResponseEntity<ResponseDto> GetAllDetails() {
        List<User> response = service.getall();
        ResponseDto responseDto = new ResponseDto(" All  user's List ", response);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDto> editData(@PathVariable int id, @Valid @RequestBody UserDto userDto) {
        String response = service.editById(id, userDto);
        ResponseDto responseDTO = new ResponseDto("Updated Book Details Successfully", response);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getGroupByAgeunder18")
    public ResponseEntity<ResponseDto> getAllUsersByAgeUnder18() {
        int newUser = service.getAllUsersByAgeUnder18();
        ResponseDto responseDTO = new ResponseDto("All Users Age records retrieved successfully !", newUser);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getGroupByAge18to40")
    public ResponseEntity<ResponseDto> getAllUsersByAge() {
        int newUser = service.getAllUsersByAge();
        ResponseDto responseDTO = new ResponseDto("All Users Age records retrieved successfully !", newUser);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getGroupByAgeAbove40")
    public ResponseEntity<ResponseDto> getAllUsersByAgeAbove40() {
        int newUser = service.getAllUsersByAgeAbove40();
        ResponseDto responseDTO = new ResponseDto("All Users Age records retrieved successfully !", newUser);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update-profilePic")
    public ResponseEntity<ResponseDto> changeProfilepic(@RequestParam int userId, @RequestParam String profilePic) {
        User user = service.changeCartQty(userId, profilePic);
        ResponseDto responseDTO = new ResponseDto("Cart quantity changed successfully", user);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{address}")
    public ResponseEntity<ResponseDto> getUserByLocation(@PathVariable String address) {
        int newUser = service.getAllUsersbyLocation(address);
        ResponseDto responseDTO = new ResponseDto("Data by using Location!", newUser);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getgender/{gender}")
    public ResponseEntity<ResponseDto> getUserByGender(@PathVariable String gender) {
        int newUser = service.getAllUsersbyGender(gender);
        ResponseDto responseDTO = new ResponseDto("Particular gender percentage....", newUser + "%");
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }


    @GetMapping(value = "/recent-registration")
    public ResponseEntity<ResponseDto> getLatestRegistration() {
        List<User> newUser = service.getRecentRegistrationList();
        ResponseDto responseDTO = new ResponseDto("Recent Registration....", newUser);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/all-registration")
    public ResponseEntity<ResponseDto> getALLRegistration() {
        List<User> newUser = service.getAllRegistrationList();
        ResponseDto responseDTO = new ResponseDto("All Registration....", newUser);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/addpermission")
    public ResponseEntity<ResponseDto> addBook(@Valid @RequestBody UserPrivilegeDto userPrivilegeDto) {
        UserPrivilege permission = service.addpermission(userPrivilegeDto);
        ResponseDto responseDTO = new ResponseDto("cart details added", permission);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/loginhistory/{email}")
    public ResponseEntity<ResponseDto> getLatestRegistration(@PathVariable String email) {
        List<LoginHistory> loginHistorys = service.getLoginHistory(email);
        ResponseDto responseDTO = new ResponseDto("Recent Registration....", loginHistorys);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }
}