package com.example.usermanagement;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class UserManagementApplication {

    public static void main(String[] args) {
        
        SpringApplication.run(UserManagementApplication.class, args);
        System.out.println("Hello...");
        log.info("Application Loaded Successfully.");
    }
        
    }



