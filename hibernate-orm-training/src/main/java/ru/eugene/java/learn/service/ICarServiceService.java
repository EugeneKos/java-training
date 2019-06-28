package ru.eugene.java.learn.service;

import ru.eugene.java.learn.data.CarService;

public interface ICarServiceService {
    CarService create(String name);
    CarService getById(Long id);
}
