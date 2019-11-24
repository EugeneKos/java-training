package ru.eugene.java.learn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eugene.java.learn.data.User;
import ru.eugene.java.learn.repository.UserRepository;
import ru.eugene.java.learn.service.IUserService;

import java.util.Set;

@Service
public class UserServiceImpl implements IUserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(Long id, String name, String surname) {
        return userRepository.save(new User(id, name, surname));
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Set<User> getAll() {
        return userRepository.findAll();
    }
}
