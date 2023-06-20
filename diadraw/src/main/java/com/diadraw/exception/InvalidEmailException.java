package com.diadraw.exception;

public class InvalidEmailException extends Exception{

    private final static String ERROR_MESSAGE = "InvalidEmail";

    public InvalidEmailException() {
        super(ERROR_MESSAGE);
    }
}
