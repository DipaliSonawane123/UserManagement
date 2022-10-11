package com.example.usermanagement.exception;


import com.example.usermanagement.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;
@ControllerAdvice
@Slf4j
public class ExceptionHandlerUser {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> error_message = errorList.stream()
                .map(objErr -> objErr.getDefaultMessage())
                .collect(Collectors.toList());
        ResponseDto responseDTO = new ResponseDto("Exception while processing REST request", error_message.toString());
        return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(userException.class)
    public ResponseEntity<ResponseDto> handleAddressBookException(userException exception){
        ResponseDto resDTO = new ResponseDto("Exception while processing REST request", exception.getMessage());
        return new ResponseEntity(resDTO, HttpStatus.BAD_REQUEST);

    }
}
