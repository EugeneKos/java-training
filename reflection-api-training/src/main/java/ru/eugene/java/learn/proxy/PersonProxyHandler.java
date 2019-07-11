package ru.eugene.java.learn.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PersonProxyHandler implements InvocationHandler {
    private PersonService personService;

    public PersonProxyHandler(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        method.invoke(personService, args);
        System.out.println("after");
        return null;
    }
}
