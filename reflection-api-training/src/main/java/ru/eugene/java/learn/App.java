package ru.eugene.java.learn;

import ru.eugene.java.learn.proxy.PersonProxyHandler;
import ru.eugene.java.learn.proxy.PersonService;
import ru.eugene.java.learn.proxy.PersonServiceImpl;

import java.lang.reflect.Proxy;

public class App {
    public static void main(String[] args) {
        testPersonProxy();
    }

    private static void testPersonProxy() {
        PersonService personService = new PersonServiceImpl();

        PersonService proxy = (PersonService) Proxy
                .newProxyInstance(
                        personService.getClass().getClassLoader(),
                        personService.getClass().getInterfaces(),
                        new PersonProxyHandler(personService));

        proxy.degradation();
    }
}
