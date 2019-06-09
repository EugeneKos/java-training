package ru.eugene.java.learn.structure.proxy;

public class HardServiceImpl implements HardeService {
    @Override
    public void api1() {
        System.out.println("api 1");
    }

    @Override
    public void api2() {
        System.out.println("api 2");
    }

    @Override
    public void api3() {
        System.out.println("api 3");
    }
}
