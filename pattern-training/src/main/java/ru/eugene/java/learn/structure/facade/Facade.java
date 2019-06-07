package ru.eugene.java.learn.structure.facade;

/**
 * Смысл паттерна Фасад в том, что мы скрываем сложную логику за одним методом,
 * но сложная логика должна быть связана с одной глобальной опрацией.
 * Например как метод save() который сохраняет в базу, за этим методом может скрываться много
 * классов и методов.
 */
public class Facade {
    public void performHardLogic(){
        HardLogicStep1 step1 = new HardLogicStep1();
        step1.step1();
        HardLogicStep2 step2 = new HardLogicStep2();
        step2.step2();
        HardLogicStep3 step3 = new HardLogicStep3();
        step3.step3();
    }
}
