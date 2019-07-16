package ru.eugene.java.learn.proxy;

import java.lang.reflect.Proxy;

public class ProxyExample {
    public void testPersonProxy() {
        PersonService personService = new PersonServiceImpl();

        PersonService proxy = (PersonService) Proxy
                .newProxyInstance(
                        personService.getClass().getClassLoader(),
                        personService.getClass().getInterfaces(),
                        new PersonProxyHandler(personService));

        proxy.degradation();
    }
}
