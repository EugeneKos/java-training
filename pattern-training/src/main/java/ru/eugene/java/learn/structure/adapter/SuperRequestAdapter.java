package ru.eugene.java.learn.structure.adapter;

/**
 * Смысл паттерна Адаптер. Класс адаптер реализует интерефейс или наследует класс,
 * для которого нам нужен адаптер и передаем объект адаптеру который нужно адаптировать,
 * делегтруя на него всю работу.
 */
public class SuperRequestAdapter implements SuperRequest {
    private SimpleRequest simpleRequest;

    public SuperRequestAdapter(SimpleRequest simpleRequest) {
        this.simpleRequest = simpleRequest;
    }

    @Override
    public String getHeader() {
        return simpleRequest.getHeader();
    }

    @Override
    public String getBody() {
        return simpleRequest.getBody();
    }
}
