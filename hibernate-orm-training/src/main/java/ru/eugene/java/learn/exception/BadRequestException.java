package ru.eugene.java.learn.exception;

public class BadRequestException extends RuntimeException {
    private static final long serialVersionUID = 2083181650979822356L;

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
