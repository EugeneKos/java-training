package ru.eugene.java.learn.exception;

public class NotUniqueException extends RuntimeException {
    private static final long serialVersionUID = -4766841265681137050L;

    public NotUniqueException(String message) {
        super(message);
    }
}
