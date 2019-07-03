package ru.eugene.java.learn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eugene.java.learn.data.CarService;
import ru.eugene.java.learn.exception.NotFoundException;
import ru.eugene.java.learn.repository.CarServiceRepository;
import ru.eugene.java.learn.service.ICarServiceService;

@Service
public class CarServiceServiceImpl implements ICarServiceService {
    private CarServiceRepository carServiceRepository;

    @Autowired
    public CarServiceServiceImpl(CarServiceRepository carServiceRepository) {
        this.carServiceRepository = carServiceRepository;
    }

    @Override
    public CarService create(String name) {
        CarService carService = new CarService();
        carService.setName(name);
        return carServiceRepository.save(carService);
    }

    @Override
    public CarService getById(Long id) {
        return carServiceRepository.getById(id)
                .orElseThrow(() -> new NotFoundException("car service by id: " + id + " not found"));
    }

    @Override
    public CarService getByName(String name) {
        return carServiceRepository.findByName(name);
    }
}
