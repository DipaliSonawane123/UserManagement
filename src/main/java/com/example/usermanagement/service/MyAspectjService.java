package com.example.usermanagement.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class MyAspectjService {
    @Before(value="execution(* com.example.usermanagement.service.UserService.*(..))")
    public void Before(JoinPoint joinpoint){
        System.out.println("Before:"+joinpoint.getSignature().getName());
    }

        @After(value="execution(* com.example.usermanagement.service.UserService.*(..))")
        public void After(JoinPoint joinpoint){
            System.out.println("After:"+ Arrays.toString(joinpoint.getArgs()));
        }

}