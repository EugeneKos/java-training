package ru.eugene.java.learn.generator.abstractfactory;

import ru.eugene.java.learn.generator.abstractfactory.model.Engine;
import ru.eugene.java.learn.generator.abstractfactory.model.SportEngine;
import ru.eugene.java.learn.generator.abstractfactory.model.SportTransmission;
import ru.eugene.java.learn.generator.abstractfactory.model.Transmission;

public class SportRepairPartsFactory implements RepairPartsFactory {
    @Override
    public Engine saleEngine() {
        return new SportEngine();
    }

    @Override
    public Transmission saleTransmission() {
        return new SportTransmission();
    }
}
