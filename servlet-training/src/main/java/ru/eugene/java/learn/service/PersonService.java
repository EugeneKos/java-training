package ru.eugene.java.learn.service;

import ru.eugene.java.learn.data.Person;
import ru.eugene.java.learn.exception.PersonAlreadyExistException;

public interface PersonService {
    Person create(String firstName, String lastName, String login, String password) throws PersonAlreadyExistException;
    Person getByLogin(String login);
}
