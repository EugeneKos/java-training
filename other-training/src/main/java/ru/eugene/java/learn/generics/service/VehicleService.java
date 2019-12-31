package ru.eugene.java.learn.generics.service;

import ru.eugene.java.learn.generics.data.Car;
import ru.eugene.java.learn.generics.data.Vehicle;

import java.util.List;
import java.util.function.Predicate;

public interface VehicleService {
    /**
     * Если с аргумента данные читаются, то аргумент является производителем Producer
     * и следуте использовать (? extends T)
     * @param vehicles
     */
    void printVehicles1(List<? extends Vehicle> vehicles);
    void printVehicles2(List<Vehicle> vehicles);

    /**
     * В данном случае мы можем передать Predicate<Vehicle> predicate
     * Потому что в predicate мы передаем данные, такой аргумент является
     * потребителем Consumer
     * @param cars
     * @param predicate
     * @return
     */
    List<Car> filter(List<Car> cars, Predicate<? super Car> predicate);
}
