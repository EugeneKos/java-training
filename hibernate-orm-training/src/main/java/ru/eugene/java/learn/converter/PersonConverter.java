package ru.eugene.java.learn.converter;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.eugene.java.learn.data.Person;
import ru.eugene.java.learn.data.dto.PersonDTO;

@Service
public class PersonConverter {
    private Mapper mapper;

    @Autowired
    public PersonConverter(Mapper mapper) {
        this.mapper = mapper;
    }

    public Person convertToPerson(PersonDTO dto){
        if(dto == null){
            return null;
        }
        return mapper.map(dto, Person.class);
    }

    public PersonDTO convertToPersonDTO(Person entity){
        if(entity == null){
            return null;
        }
        return mapper.map(entity, PersonDTO.class);
    }
}
