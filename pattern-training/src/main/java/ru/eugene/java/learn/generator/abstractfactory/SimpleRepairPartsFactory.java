package ru.eugene.java.learn.generator.abstractfactory;

import ru.eugene.java.learn.generator.abstractfactory.model.Engine;
import ru.eugene.java.learn.generator.abstractfactory.model.SimpleEngine;
import ru.eugene.java.learn.generator.abstractfactory.model.SimpleTransmission;
import ru.eugene.java.learn.generator.abstractfactory.model.Transmission;

public class SimpleRepairPartsFactory implements RepairPartsFactory {
    @Override
    public Engine saleEngine() {
        return new SimpleEngine();
    }

    @Override
    public Transmission saleTransmission() {
        return new SimpleTransmission();
    }
}
