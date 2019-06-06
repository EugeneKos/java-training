package ru.eugene.java.learn.generator.factorymethod;

import ru.eugene.java.learn.generator.factorymethod.model.Ship;
import ru.eugene.java.learn.generator.factorymethod.model.Transport;

public class ShipTransportCreator implements TransportCreator {
    @Override
    public Transport create() {
        return new Ship();
    }
}
