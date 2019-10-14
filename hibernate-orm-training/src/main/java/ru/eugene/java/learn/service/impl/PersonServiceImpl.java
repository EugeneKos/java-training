package ru.eugene.java.learn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.eugene.java.learn.converter.PersonConverter;
import ru.eugene.java.learn.data.Person;
import ru.eugene.java.learn.data.dto.PersonDTO;
import ru.eugene.java.learn.exception.NotFoundException;
import ru.eugene.java.learn.exception.NotUniqueException;
import ru.eugene.java.learn.repository.PersonRepository;
import ru.eugene.java.learn.service.IPersonService;

@Service
public class PersonServiceImpl implements IPersonService {
    private PersonRepository personRepository;
    private PersonConverter personConverter;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, PersonConverter personConverter) {
        this.personRepository = personRepository;
        this.personConverter = personConverter;
    }

    @Override
    public PersonDTO create(PersonDTO personDTO) {
        return update(personDTO);
    }

    @Override
    public PersonDTO update(PersonDTO personDTO) {
        if(personDTO == null){
            return null;
        }

        Person person = personConverter.convertToPerson(personDTO);

        assertExistById(person);
        assertUniqueByLogin(person);

        person = personRepository.saveAndFlush(person);
        return personConverter.convertToPersonDTO(person);
    }

    private void assertExistById(Person person){
        if(person.getId() == null){
            return;
        }
        personRepository.findById(person.getId()).orElseThrow(
                () -> new NotFoundException("Person with id " + person.getId() + " not found")
        );
    }

    private void assertUniqueByLogin(Person person){
        if(person.getLogin() == null){
            return;
        }

        Person foundedByLogin = personRepository.findByLogin(person.getLogin());

        if(foundedByLogin != null && !foundedByLogin.getId().equals(person.getId())){
            throw new NotUniqueException("Person with login " + person.getLogin() + " already exist");
        }
    }

    @Override
    @Transactional
    public PersonDTO getByLogin(String login) {
        Person foundedByLogin = personRepository.findByLogin(login);
        return personConverter.convertToPersonDTO(foundedByLogin);
    }
}
