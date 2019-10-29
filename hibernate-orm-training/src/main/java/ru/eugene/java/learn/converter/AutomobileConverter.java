package ru.eugene.java.learn.converter;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.eugene.java.learn.data.Automobile;
import ru.eugene.java.learn.data.dto.AutomobileDTO;

@Service
public class AutomobileConverter {
    private Mapper mapper;

    @Autowired
    public AutomobileConverter(Mapper mapper) {
        this.mapper = mapper;
    }

    public Automobile convertToAutomobile(AutomobileDTO dto){
        if(dto == null){
            return null;
        }
        return mapper.map(dto, Automobile.class);
    }

    public AutomobileDTO convertToAutomobileDTO(Automobile entity){
        if(entity == null){
            return null;
        }
        return mapper.map(entity, AutomobileDTO.class);
    }
}
