package ru.eugene.java.learn.generator;

import ru.eugene.java.learn.Util;
import ru.eugene.java.learn.generator.abstractfactory.RepairPartsFactory;
import ru.eugene.java.learn.generator.abstractfactory.SimpleRepairPartsFactory;
import ru.eugene.java.learn.generator.abstractfactory.SportRepairPartsFactory;
import ru.eugene.java.learn.generator.abstractfactory.model.Engine;
import ru.eugene.java.learn.generator.abstractfactory.model.Transmission;
import ru.eugene.java.learn.generator.builder.Computer;
import ru.eugene.java.learn.generator.builder.ComputerBuilder;
import ru.eugene.java.learn.generator.factorymethod.ShipTransportCreator;
import ru.eugene.java.learn.generator.factorymethod.model.Transport;
import ru.eugene.java.learn.generator.factorymethod.TransportCreator;
import ru.eugene.java.learn.generator.prototype.BmwCar;
import ru.eugene.java.learn.generator.prototype.Car;
import ru.eugene.java.learn.generator.singleton.DataSource;

public class GeneratorMain {
    public static void main(String[] args) {
        Util.printStartTest("Factory method");
        testFactoryMethod();
        Util.printFinishTest();

        Util.printStartTest("Abstract factory");
        testAbstractFactory();
        Util.printFinishTest();

        Util.printStartTest("Prototype");
        testPrototype();
        Util.printFinishTest();

        Util.printStartTest("Singleton");
        testSingleton();
        Util.printFinishTest();

        Util.printStartTest("Builder");
        testBuilder();
        Util.printFinishTest();
    }

    /**
     * Тест паттерна фабричный метод
     */
    private static void testFactoryMethod(){
        TransportCreator creator = new ShipTransportCreator();
        Transport ship = creator.create();
        ship.deliver();
    }

    /**
     * Тест паттерна абстрактной фабрики
     */
    private static void testAbstractFactory(){
        RepairPartsFactory factory = new SportRepairPartsFactory();
        Engine engine = factory.saleEngine();
        engine.checkEngine();

        factory = new SimpleRepairPartsFactory();
        Transmission transmission = factory.saleTransmission();
        transmission.checkTransmission();
    }

    /**
     * Тест паттерна прототипа
     */
    //fixme : Лучше сделать на JUnit
    private static void testPrototype(){
        BmwCar car = new BmwCar("bmw", "e34", "garret");
        BmwCar copy = car.cloneCar();
        if(isEquals(car, copy)){
            System.out.println("Тест 1 пройден");
        } else {
            System.err.println("Тест 1 завален");
        }
        copy.setTurbo("garret 0");
        if(isEquals(car, copy)){
            System.err.println("Тест 2 завален");
        } else {
            System.out.println("Тест 2 пройден");
        }
    }

    private static boolean isEquals(Car original, Car copy){
        if(original == copy){
            throw new RuntimeException("Тест не имеет смысла");
        }
        return original.equals(copy);
    }

    /**
     * Тест паттерна синглтона
     */
    private static void testSingleton(){
        DataSource dataSource = DataSource.getInstance();
        DataSource dataSource1 = DataSource.getInstance();
        System.out.println(dataSource.toString().equals(dataSource1.toString()));
    }

    /**
     * Тест паттерна строителя
     */
    private static void testBuilder(){
        ComputerBuilder builder = new ComputerBuilder("x-tream 2.0");
        Computer computer = builder.getComputer();
        System.out.println("first version: " + computer);
        computer = builder.setOc("Windows 10").setChipSet("Intel Core i7").setRam(16).getComputer();
        System.out.println("second version: " + computer);
    }
}
