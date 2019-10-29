package ru.eugene.java.learn.converter;

import org.apache.commons.collections.CollectionUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.eugene.java.learn.data.Person;
import ru.eugene.java.learn.data.dto.AutomobileDTO;
import ru.eugene.java.learn.data.dto.PersonDTO;
import ru.eugene.java.learn.data.dto.PersonTreeDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonConverter {
    private Mapper mapper;

    private AutomobileConverter automobileConverter;

    @Autowired
    public PersonConverter(Mapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setAutomobileConverter(AutomobileConverter automobileConverter) {
        this.automobileConverter = automobileConverter;
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

    public PersonTreeDTO convertToPersonTreeDTO(Person entity){
        if(entity == null){
            return null;
        }

        PersonTreeDTO personTreeDTO = mapper.map(entity, PersonTreeDTO.class);

        if(CollectionUtils.isNotEmpty(entity.getAutomobiles())){
            List<AutomobileDTO> automobileDTOList = entity.getAutomobiles().stream()
                    .map(automobileConverter::convertToAutomobileDTO)
                    .collect(Collectors.toList());

            personTreeDTO.setAutomobileDTOList(automobileDTOList);
        }

        return personTreeDTO;
    }
}
