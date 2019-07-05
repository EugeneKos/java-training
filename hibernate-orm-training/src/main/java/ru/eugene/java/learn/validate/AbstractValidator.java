package ru.eugene.java.learn.validate;

import ru.eugene.java.learn.exception.ValidateException;

public interface AbstractValidator<T> {
    void validate(T object) throws ValidateException;
}
