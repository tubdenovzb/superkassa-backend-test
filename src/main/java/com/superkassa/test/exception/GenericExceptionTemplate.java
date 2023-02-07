package com.superkassa.test.exception;

public class GenericExceptionTemplate {

    private final String message;

    public GenericExceptionTemplate(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
