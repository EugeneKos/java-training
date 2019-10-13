package ru.eugene.java.learn.exception;

public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = 3980237707946520697L;

    public NotFoundException(String message) {
        super(message);
    }
}
