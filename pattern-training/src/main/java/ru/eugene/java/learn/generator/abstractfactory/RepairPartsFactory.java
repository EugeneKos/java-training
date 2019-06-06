package ru.eugene.java.learn.generator.abstractfactory;

import ru.eugene.java.learn.generator.abstractfactory.model.Engine;
import ru.eugene.java.learn.generator.abstractfactory.model.Transmission;

/**
 * Описываем интерфейс который создает несколько абстрактных моделей (фабрика)
 * В реализации фабрики описываем создание разных моделей одной тематики
 */
public interface RepairPartsFactory {
    Engine saleEngine();
    Transmission saleTransmission();
}
