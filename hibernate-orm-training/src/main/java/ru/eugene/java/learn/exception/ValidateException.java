package ru.eugene.java.learn.exception;

public class ValidateException extends Exception {
    private static final long serialVersionUID = 296819552568265734L;

    public ValidateException(String message) {
        super(message);
    }
}
