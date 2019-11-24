package ru.eugene.java.learn.service;

import ru.eugene.java.learn.data.User;

import java.util.Set;

public interface IUserService {
    User create(Long id, String name, String surname);
    User getById(Long id);
    Set<User> getAll();
}
