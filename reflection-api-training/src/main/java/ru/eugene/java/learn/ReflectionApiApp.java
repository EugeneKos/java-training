package ru.eugene.java.learn;

import ru.eugene.java.learn.proxy.ProxyExample;
import ru.eugene.java.learn.reflection.ReflectionExample;

public class ReflectionApiApp {
    public static void main(String[] args) throws Exception {
        ProxyExample proxyExample = new ProxyExample();
        proxyExample.testPersonProxy();

        ReflectionExample reflectionExample = new ReflectionExample();
        reflectionExample.testReflectionComputerModel();
    }
}
