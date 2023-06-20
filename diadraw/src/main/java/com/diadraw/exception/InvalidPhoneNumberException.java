package com.diadraw.exception;

public class InvalidPhoneNumberException extends Exception{

    private final static String ERROR_MESSAGE = "InvalidPhoneNumber";

    public InvalidPhoneNumberException() {
        super(ERROR_MESSAGE);
    }
}
