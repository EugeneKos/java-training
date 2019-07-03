package ru.eugene.java.learn.service;

import ru.eugene.java.learn.data.Automobile;
import ru.eugene.java.learn.data.CarService;

import java.util.List;

public interface ICarServiceService {
    CarService create(String name);
    CarService getById(Long id);
    CarService getByName(String name);

    List<Automobile> getAllAutomobilesByCarServiceName(String carServiceName);
}
