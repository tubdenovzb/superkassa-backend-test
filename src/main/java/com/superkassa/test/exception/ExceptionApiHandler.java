package com.superkassa.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionApiHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericExceptionTemplate> handleException(Exception e) {
        GenericExceptionTemplate ge = new GenericExceptionTemplate(e.getMessage());
        return new ResponseEntity<>(ge, HttpStatus.I_AM_A_TEAPOT);
    }

    @ExceptionHandler(ExampleNotFoundException.class)
    public ResponseEntity<GenericExceptionTemplate> handleNotFoundException(Exception e) {
        GenericExceptionTemplate ge = new GenericExceptionTemplate(e.getMessage());
        return new ResponseEntity<>(ge, HttpStatus.NOT_FOUND);
    }
}
