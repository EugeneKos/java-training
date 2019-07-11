package ru.eugene.java.learn.proxy;

public class PersonServiceImpl implements PersonService {
    @Override
    public void degradation() {
        System.out.println("degradation");
    }
}
