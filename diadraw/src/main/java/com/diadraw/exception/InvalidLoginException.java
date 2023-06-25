package com.diadraw.exception;

public class InvalidLoginException extends Exception {

    private final static String ERROR_MESSAGE = "InvalidLogin";

    public InvalidLoginException() {
        super(ERROR_MESSAGE);
    }
}
