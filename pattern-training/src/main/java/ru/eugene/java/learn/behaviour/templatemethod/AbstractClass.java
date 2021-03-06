package ru.eugene.java.learn.behaviour.templatemethod;

/**
 * Паттерн Шаблонный метод (Template Method) Применяется когда есть алгоритм состоящий из нескольких шагов и
 * некоторые шаги необходимо реализовать разными способами, для этого делаем абстрактный класс и абстрактные методы.
 * Выделяем один метод (шаблонный метод) который будет запускать шаги.
 *
 * Один из недостатков:
 * Вы можете нарушить принцип подстановки Барбары Лисков, изменяя базовое поведение одного из шагов алгоритма через подкласс.
 *
 * Принцип подстановки Барбары Лисков:
 * Объекты в программе могут быть заменены их наследниками без изменения свойств программы.
 */
public abstract class AbstractClass {
    /**
     * Шаблонный метод, который состоит из вызовов шагов алгоритма
     */
    public void performAlgorithm(){
        step1();
        step2();
        step3();
        step4();
    }

    protected abstract void step1();

    protected void step2(){
        System.out.println("Выполнение стандартного шага 2");
    }

    protected abstract void step3();

    protected void step4(){
        System.out.println("Выполнение стандартного шага 4");
    }
}
