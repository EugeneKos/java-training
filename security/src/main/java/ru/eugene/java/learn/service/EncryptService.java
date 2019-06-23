package ru.eugene.java.learn.service;

import ru.eugene.java.learn.data.EncryptModel;

public interface EncryptService {
    <T> EncryptModel<T> encrypt(String name, T object, Class<T> clazz);
    <T> T decrypt(EncryptModel<T> model);
}
