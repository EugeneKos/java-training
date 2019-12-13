package ru.eugene.java.learn.generics.service;

import org.junit.Test;

import ru.eugene.java.learn.generics.data.Car;
import ru.eugene.java.learn.generics.data.Ship;
import ru.eugene.java.learn.generics.data.Vehicle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class VehicleServiceTest {
    private VehicleService vehicleService = new VehicleServiceImpl();

    private List<Vehicle> vehicles = new ArrayList<>(
            Arrays.asList(
                    new Vehicle("1"),
                    new Car("2", 2),
                    new Ship("3", "Price")
            )
    );

    private List<Car> cars = new ArrayList<>(
            Arrays.asList(
                    new Car("1", 4),
                    new Car("2", 2)
            )
    );

    @Test
    public void genericTest_1(){
        vehicleService.printVehicles1(vehicles);
        vehicleService.printVehicles2(vehicles);
    }

    @Test
    public void genericTest_2(){
        vehicleService.printVehicles1(cars);

        //Ошибка компиляции.
        //vehicleService.printVehicles2(cars);
    }

    @Test
    public void filterTest(){
        Predicate<Vehicle> predicate = vehicle -> vehicle.getNumber().startsWith("1");
        List<Car> filter = vehicleService.filter(cars, predicate);
        System.out.println(filter);
    }
}