package ru.eugene.java.learn.behaviour.mediator;

/**
 * Суть паттерна Посредник (Mediator) нужен для того чтобы убрать зависимость между
 * двумя объектами которые работаеют друг с другом и переложить эту работу на сторонний класс
 * Например два класса графических компонентов, чтобы один класс не зависел от другого,
 * мы передаем оба класса в класс посредника и предоставляем самого посредника этим классам.
 * При вызове метода графического компонента, мы передаем вызов посреднику, где он сам решит с какими
 * графическими компонентами работать дальше.
 */
public interface Mediator {
    void registryComponent(Component component);
    void show();
}
