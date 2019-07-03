package ru.eugene.java.learn.service;

import ru.eugene.java.learn.data.Automobile;

import java.util.List;

public interface IAutomobileService {
    Automobile create(String mark, String model, String stateNumber);
    Automobile getById(Long id);
    Automobile getByStateNumber(String stateNumber);

    List<Automobile> getAllAutomobilesByPersonCode(String personCode);
}
