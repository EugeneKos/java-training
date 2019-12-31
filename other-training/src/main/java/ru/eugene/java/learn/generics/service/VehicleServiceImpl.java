package ru.eugene.java.learn.generics.service;

import ru.eugene.java.learn.generics.data.Car;
import ru.eugene.java.learn.generics.data.Vehicle;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class VehicleServiceImpl implements VehicleService {
    @Override
    public void printVehicles1(List<? extends Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles){
            System.out.println(vehicle);
        }
    }

    @Override
    public void printVehicles2(List<Vehicle> vehicles) {
        printVehicles1(vehicles);
    }

    @Override
    public List<Car> filter(List<Car> cars, Predicate<? super Car> predicate) {
        return cars.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
