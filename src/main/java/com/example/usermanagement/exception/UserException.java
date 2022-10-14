package com.example.usermanagement.exception;

/**
 * UserException class for custom error message
 */
public class UserException extends RuntimeException {
    public UserException(String message) {

        super(message);
    }
}