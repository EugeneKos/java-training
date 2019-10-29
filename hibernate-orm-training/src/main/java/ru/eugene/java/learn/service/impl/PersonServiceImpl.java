package ru.eugene.java.learn.service.impl;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.eugene.java.learn.converter.PersonConverter;
import ru.eugene.java.learn.data.Person;
import ru.eugene.java.learn.data.dto.PersonDTO;
import ru.eugene.java.learn.data.dto.PersonTreeDTO;
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

        fillAutomobiles(person);

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

    private void fillAutomobiles(Person person){
        if(person.getId() == null){
            return;
        }
        Person foundedByIdWithAutomobiles = personRepository.findByIdWithAutomobiles(person.getId());
        if(CollectionUtils.isNotEmpty(foundedByIdWithAutomobiles.getAutomobiles())){
            person.setAutomobiles(foundedByIdWithAutomobiles.getAutomobiles());
        }
    }

    @Override
    @Transactional
    public PersonDTO getByLogin(String login) {
        Person foundedByLogin = personRepository.findByLogin(login);
        return personConverter.convertToPersonDTO(foundedByLogin);
    }

    @Override
    public PersonTreeDTO getByLoginWithAutomobile(String login) {
        Person foundedByLogin = personRepository.findByLoginWithAutomobiles(login);
        return personConverter.convertToPersonTreeDTO(foundedByLogin);
    }

    @Override
    @Transactional
    public void deleteByLogin(String login) {
        personRepository.deleteByLogin(login);
    }
}
