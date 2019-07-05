package ru.eugene.java.learn.service;

import ru.eugene.java.learn.data.Person;

public interface IPersonService {
    Person create(String name, String surname, String code);
    Person getById(Long id);
    Person getByCode(String code);

    void deleteByCode(String code);
}
