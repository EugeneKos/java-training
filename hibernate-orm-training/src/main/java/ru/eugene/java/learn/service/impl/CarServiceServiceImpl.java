package ru.eugene.java.learn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eugene.java.learn.data.Automobile;
import ru.eugene.java.learn.data.CarService;
import ru.eugene.java.learn.data.CarServiceLinkAuto;
import ru.eugene.java.learn.exception.NotFoundException;
import ru.eugene.java.learn.repository.CarServiceLinkAutoRepository;
import ru.eugene.java.learn.repository.CarServiceRepository;
import ru.eugene.java.learn.service.ICarServiceService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceServiceImpl implements ICarServiceService {
    private CarServiceRepository carServiceRepository;
    private CarServiceLinkAutoRepository carServiceLinkAutoRepository;

    @Autowired
    public CarServiceServiceImpl(CarServiceRepository carServiceRepository) {
        this.carServiceRepository = carServiceRepository;
    }

    @Autowired
    public void setCarServiceLinkAutoRepository(CarServiceLinkAutoRepository carServiceLinkAutoRepository) {
        this.carServiceLinkAutoRepository = carServiceLinkAutoRepository;
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

    @Override
    public List<Automobile> getAllAutomobilesByCarServiceName(String carServiceName) {
        CarService carService = carServiceRepository.findByName(carServiceName);
        List<CarServiceLinkAuto> carServiceLinkAutos = carServiceLinkAutoRepository.findAllByCarService(carService);
        return carServiceLinkAutos.stream().map(CarServiceLinkAuto::getAutomobile).collect(Collectors.toList());
    }
}
