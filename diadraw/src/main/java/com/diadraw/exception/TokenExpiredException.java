package com.diadraw.exception;

public class TokenExpiredException extends Exception {

    private final static String ERROR_MESSAGE = "TokenExpired";

    public TokenExpiredException() {
        super(ERROR_MESSAGE);
    }
}
