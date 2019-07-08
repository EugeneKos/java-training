package ru.eugene.java.learn.service.impl;

import ru.eugene.java.learn.service.EncryptService;
import ru.eugene.java.learn.service.EncryptServiceCreator;

public class EncryptServiceImplCreator implements EncryptServiceCreator {
    @Override
    public EncryptService createEncryptService(String secretKey) {
        return new EncryptServiceImpl(secretKey);
    }
}
