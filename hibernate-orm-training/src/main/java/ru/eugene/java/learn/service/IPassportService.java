package ru.eugene.java.learn.service;

import ru.eugene.java.learn.data.Passport;

public interface IPassportService {
    Passport create(String uin);
    Passport getById(Long id);
}
