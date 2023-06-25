package com.diadraw.exception;

public class CodeNotFoundException extends Exception {

    private final static String ERROR_MESSAGE = "CodeNotFound";

    public CodeNotFoundException() {
        super(ERROR_MESSAGE);
    }
}
