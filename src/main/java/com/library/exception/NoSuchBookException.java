package com.library.exception;

public class NoSuchBookException extends RuntimeException {

    public NoSuchBookException() {
    }

    public NoSuchBookException(String message) {
        super(message);
    }
}
