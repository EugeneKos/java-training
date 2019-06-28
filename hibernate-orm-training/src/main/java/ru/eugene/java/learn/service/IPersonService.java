package ru.eugene.java.learn.service;

import ru.eugene.java.learn.data.Person;

public interface IPersonService {
    Person create(String name, String surname);
    Person getById(Long id);
}
