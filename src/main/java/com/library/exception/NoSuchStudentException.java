package com.library.exception;

import com.library.model.Student;

import java.util.function.Supplier;

public class NoSuchStudentException extends RuntimeException implements Supplier<NoSuchStudentException> {
    public NoSuchStudentException() {
    }

    public NoSuchStudentException(String message) {
        super(message);
    }

    @Override
    public NoSuchStudentException get() {
        return new NoSuchStudentException();
    }
}
