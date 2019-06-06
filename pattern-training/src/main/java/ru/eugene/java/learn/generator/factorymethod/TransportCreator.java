package ru.eugene.java.learn.generator.factorymethod;

import ru.eugene.java.learn.generator.factorymethod.model.Transport;

/**
 * Порождающий паттерн проектирования Фабричный метод.
 *
 * Суть в том если мы хотим создать разные объекты которые реализуют один интерфейс,
 *
 * мы создаем абстрактный creator который должен создать абстрактный транспорт,
 *
 * а конкретные реализации creator решат какие именно реализации транспорта создать.
 */
public interface TransportCreator {
    Transport create();
}
