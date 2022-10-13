package com.example.usermanagement.service;

import com.example.usermanagement.Repo.UserPrivilegeRepo;
import com.example.usermanagement.Repo.UserRepo;
import com.example.usermanagement.dto.LoginDto;
import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.dto.UserPrivilegeDto;
import com.example.usermanagement.exception.userException;
import com.example.usermanagement.model.User;
import com.example.usermanagement.model.UserPrivilege;
import com.example.usermanagement.util.EmailSenderService;
import com.example.usermanagement.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.SortedMap;

@Service
public class UserService implements Iuserservice {
    @Autowired
    UserRepo userRepo;
    @Autowired
    UserPrivilegeRepo userPrivilegeRepo;
    @Autowired
    TokenUtil tokenUtil;
    @Autowired
    EmailSenderService emailSender;

    @Override
    public String insertRecord(UserDto userDto) throws userException {
        User user = new User(userDto);
        userRepo.save(user);
        String token = tokenUtil.createToken(user.getUserId());
        emailSender.sendEmail(user.getEmailId(), "Added Your Details", "http://localhost:5000/user/verify/" + token);
        return token;
    }

    @Override
    public String forgotPassword(String email) {
        User editdata = userRepo.findByEmail(email);
        if (editdata != null) {
            emailSender.sendEmail(editdata.getEmailId(), "About Login", "http://localhost:5000/user/resetPassword/" + email);
            return "Reset link send sucessfully";
        } else
            throw new userException("Login Failed, Wrong email or password!!!");
    }

    @Override
    public User verifyUser(String token) {
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
    public String editById(int id, UserDto userDto) {
        User editUser = userRepo.findById(id).orElse(null);
        if (editUser != null) {
            editUser.setFirstName(userDto.getFirstName());
            editUser.setMiddleName(userDto.getMiddleName());
            editUser.setLastName(userDto.getLastName());
            editUser.setAge(userDto.getAge());
            editUser.setGender(userDto.getGender());
            editUser.setContactNo(userDto.getContactNo());
            editUser.setEmailId(userDto.getEmailId());
            editUser.setPassword(userDto.getPassword());
            editUser.setAddress(userDto.getAddress());
            editUser.setRole(userDto.getRole());
            userRepo.save(editUser);
            String token = tokenUtil.createToken(editUser.getUserId());
            emailSender.sendEmail(editUser.getEmailId(), "Added Your Details", "http://localhost:5000/user/verify/" + token);
            return token;
        } else
            throw new userException("Id:" + id + " is not present ");
    }
    @Override
    public int getAllUsersByAgeUnder18() {
        List<User> users = userRepo.findByAgeUnder18();
        return users.size();
    }
    @Override
    public int getAllUsersByAge() {
        List<User> users = userRepo.findByAge();
        return users.size();
    }
    @Override
    public int getAllUsersByAgeAbove40() {
        List<User> users = userRepo.findByAgeAbove40();
        return users.size();
    }


    @Override
    public User changeCartQty(int userId, String profilePic) {
        User user = userRepo.findById(userId).orElse(null);
        if(user == null){
            throw new userException("id is not found");
        }
        user.setProfilePic(profilePic);
        return userRepo.save(user);
    }

    @Override
    public int getAllUsersbyLocation( String address) {
        List<User> users = userRepo.findByAddress(address);
        return users.size();

    }

    @Override
        public int getAllUsersbyGender(String gender) {
        List<User> users = userRepo.findByGender(gender);
        int obtained= users.size();
        List<User>userList = getall();
        int total = userList.size();
        int  percentage= obtained * 100 / total;
        return percentage;
    }



    @Override
    public List<User> getRecentRegistrationList() {
     List<User> user =  userRepo.getRecentTegistration();
        return user;
        }

    @Override
    public List<User> getAllRegistrationList() {
        List<User> user =  userRepo.getAllregistration();
        return user;
    }

    @Override
    public UserPrivilege addpermission(UserPrivilegeDto userPrivilegeDto) {
        Optional<User> user = userRepo.findById(userPrivilegeDto.getUserId());
        if (user.isPresent()) {
            UserPrivilege details = new UserPrivilege(user.get(), userPrivilegeDto.isAddDashboard(), userPrivilegeDto.isDeleteDashboard(), userPrivilegeDto.isModifyDashboard(), userPrivilegeDto.isReadDashboard(),
                    userPrivilegeDto.isAddSettings(), userPrivilegeDto.isDeleteSettings(), userPrivilegeDto.isModifySettings(), userPrivilegeDto.isReadSettings(),
                    userPrivilegeDto.isAddUsersInformation(), userPrivilegeDto.isDeleteUsersInformation(), userPrivilegeDto.isModifyUsersInformation(), userPrivilegeDto.isReadUsersInformation(),
                    userPrivilegeDto.isAddWebPage1(), userPrivilegeDto.isDeleteWebPage1(), userPrivilegeDto.isModifyWebPage1(), userPrivilegeDto.isReadWebPage1(),
                    userPrivilegeDto.isAddWebPage2(), userPrivilegeDto.isDeleteWebPage2(), userPrivilegeDto.isModifyWebPage2(), userPrivilegeDto.isReadWebPage2(),
                    userPrivilegeDto.isAddWebPage3(), userPrivilegeDto.isDeleteWebPage3(), userPrivilegeDto.isModifyWebPage3(), userPrivilegeDto.isReadWebPage3());
            userPrivilegeRepo.save(details);
            return details;
        } else
            throw new userException(" userid and bookid is invalid");
    }



    @Override
        public List<User> getall() {
            List<User> order = userRepo.findAll();
            return order;
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


