package ru.eugene.java.learn.factory;

public class AutomobileFactory implements TransportFactory {
    @Override
    public Transport createTransport() {
        return new Automobile();
    }
}
