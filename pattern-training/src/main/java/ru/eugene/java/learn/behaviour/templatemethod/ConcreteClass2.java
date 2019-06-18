package ru.eugene.java.learn.behaviour.templatemethod;

public class ConcreteClass2 extends AbstractClass {
    @Override
    protected void step1() {
        System.out.println("Выполнение шага 1 ConcreteClass 2");
    }

    @Override
    protected void step3() {
        System.out.println("Выполнение шага 3 ConcreteClass 2");
    }
}
