package com.example.usermanagement.service;

import com.example.usermanagement.Repo.UserRepo;
import com.example.usermanagement.dto.LoginDto;
import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.exception.userException;
import com.example.usermanagement.model.User;
import com.example.usermanagement.util.EmailSenderService;
import com.example.usermanagement.util.TokenUtil;

import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements Iuserservice {
    @Autowired
    UserRepo userRepo;
    @Autowired
    TokenUtil tokenUtil;
    @Autowired
    EmailSenderService emailSender;

    @Override
    public String insertRecord(UserDto userDto) throws userException {
        User user = new User(userDto);
        userRepo.save(user);
        String token = tokenUtil.createToken(user.getUserId());
        emailSender.sendEmail(user.getEmailId(), "Added Your Details", "http://localhost:5000/user/verify/"+token);
        return token;
    }

    @Override
    public String forgotPassword(String email) {
        User editdata = userRepo.findByEmail(email);
        if (editdata != null) {
            emailSender.sendEmail(editdata.getEmailId(), "About Login", "http://localhost:5000/user/resetPassword/"+email);
            return "Reset link send sucessfully";
        } else
            throw new userException("Login Failed, Wrong email or password!!!");
    }


        @Override
        public User verifyUser (String token) {
            int id = tokenUtil.decodeToken(token);
            User user = userRepo.findById(id).orElseThrow(() -> new userException
                    ("Employee id  " + id + " note Found "));
                user.setVerified(true);
                userRepo.save(user);
                return user;
    }

    @Override
    public User loginUser(LoginDto loginDTO) {
        Optional<User> userDetails = Optional.ofNullable(userRepo.findByEmail(loginDTO.getEmail()));
        if (userDetails.isPresent()) {
            //String pass = login.get().getPassword();
            if (userDetails.get().getPassword().equals(loginDTO.getPassword())) {
                emailSender.sendEmail(userDetails.get().getEmailId(), "About Login", "Login Successful!");
                return userDetails.get();
            } else
                emailSender.sendEmail(userDetails.get().getEmailId(), "About Login", "Invalid password!");
            throw new userException("Wrong Password!");
        } else
            throw new userException("Login Failed, Wrong email or password!!!");
    }


    @Override
    public String resetPassword(LoginDto loginDTO) {
        Optional<User> userDetails = Optional.ofNullable(userRepo.findByEmail(loginDTO.getEmail()));
        String password = loginDTO.getPassword();
        if (userDetails.isPresent()) {
            userDetails.get().setPassword(password);
            userRepo.save(userDetails.get());
            return "Password Changed";
        } else
            return "Invalid Email Address";
    }
}


