package ru.eugene.java.learn.structure.proxy;

/**
 * Паттерн Прокси, по структуре схож с паттерном Декоратор.
 * Оба эти паттерна делегируют работу оригинальному объекту.
 * Разница в том что Прокси сам управляет жизнью оригинального объекта
 * Как правило оригинальные объекты создает сам Прокси, а в Декораторе оригинальный объект передается Декоратору,
 * то-есть его контролирует клиентский класс.
 */
public class HardServiceImplProxy implements HardeService {
    private HardeService hardeService;

    public HardServiceImplProxy() {
        hardeService = new HardServiceImpl();
    }

    @Override
    public void api1() {
        // Логика перед вызовом оригинального метода
        hardeService.api1();
        // Логика после вызова оригинального метода
    }

    @Override
    public void api2() {
        // Логика перед вызовом оригинального метода
        hardeService.api2();
        // Логика после вызова оригинального метода
    }

    @Override
    public void api3() {
        // Логика перед вызовом оригинального метода
        hardeService.api3();
        // Логика после вызова оригинального метода
    }
}
