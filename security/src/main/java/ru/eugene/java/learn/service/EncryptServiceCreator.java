package ru.eugene.java.learn.service;

public interface EncryptServiceCreator {
    EncryptService createEncryptService(String secretKey);
}
