package ru.eugene.java.learn.exception;

public class PersonAlreadyExistException extends Exception {
    private static final long serialVersionUID = -5886434125776678280L;

    public PersonAlreadyExistException(String message) {
        super(message);
    }
}
