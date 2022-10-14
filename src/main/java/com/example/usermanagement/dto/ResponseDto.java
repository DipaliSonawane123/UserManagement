package com.example.usermanagement.dto;

import com.example.usermanagement.model.User;
import com.example.usermanagement.model.UserPrivilege;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ResponseDto {
    private String message;
    private Object object;

    public ResponseDto(String s, String response) {
        this.message = s;
        this.object = response;
    }

    public ResponseDto(String s, User user) {
        this.message = s;
        this.object = user;
    }

    public ResponseDto(String s, List<User> response) {
        this.message = s;
        this.object = response;
    }

    public ResponseDto(String s, int newUser) {
        this.message = s;
        this.object = newUser;
    }

    public ResponseDto(String s, UserPrivilege permission) {
        this.message = s;
        this.object = permission;
    }

    public ResponseDto(String s, Object loginHistorys) {
        this.message = s;
        this.object = loginHistorys;

    }
}




