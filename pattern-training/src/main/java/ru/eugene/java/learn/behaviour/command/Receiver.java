package ru.eugene.java.learn.behaviour.command;

/**
 * Класс получатель организует бизнес-логику
 */
public class Receiver {
    public void logic(){
        System.out.println("logic without parameter");
    }

    public void logic(int a){
        System.out.println("logic with parameter " + a);
    }

    public void logic(String str){
        System.out.println("logic with string parameter " + str);
    }
}
