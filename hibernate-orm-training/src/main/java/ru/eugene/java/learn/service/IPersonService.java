package ru.eugene.java.learn.service;

import ru.eugene.java.learn.data.dto.PersonDTO;

public interface IPersonService {
    PersonDTO create(PersonDTO personDTO);
    PersonDTO update(PersonDTO personDTO);
    PersonDTO getByLogin(String login);
}
