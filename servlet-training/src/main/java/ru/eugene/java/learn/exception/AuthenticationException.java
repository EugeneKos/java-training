package ru.eugene.java.learn.exception;

public class AuthenticationException extends Exception {
    private static final long serialVersionUID = 6144287416119464202L;

    public AuthenticationException(String message) {
        super(message);
    }
}
