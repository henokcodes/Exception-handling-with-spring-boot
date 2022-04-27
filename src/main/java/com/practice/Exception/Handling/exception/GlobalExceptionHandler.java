package com.practice.Exception.Handling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.naming.NotContextException;
import java.util.Optional;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotContextException.class)
    public ResponseEntity<String> NotFoundEx(){
        return new ResponseEntity<>("The repository is empty", HttpStatus.NO_CONTENT);
    }
}
