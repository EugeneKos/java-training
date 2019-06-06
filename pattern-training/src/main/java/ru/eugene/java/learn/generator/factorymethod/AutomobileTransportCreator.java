package ru.eugene.java.learn.generator.factorymethod;

import ru.eugene.java.learn.generator.factorymethod.model.Automobile;
import ru.eugene.java.learn.generator.factorymethod.model.Transport;

public class AutomobileTransportCreator implements TransportCreator {
    @Override
    public Transport create() {
        return new Automobile();
    }
}
