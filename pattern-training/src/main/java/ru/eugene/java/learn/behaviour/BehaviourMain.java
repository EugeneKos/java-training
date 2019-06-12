package ru.eugene.java.learn.behaviour;

import ru.eugene.java.learn.behaviour.chainofresponsibility.MessageChecker;
import ru.eugene.java.learn.behaviour.command.GUI;

public class BehaviourMain {
    public static void main(String[] args) {
        testChainOfResponsibility();
        testCommand();
    }

    private static void testChainOfResponsibility(){
        MessageChecker messageChecker = new MessageChecker();
        messageChecker.checkMessage("ckffANH8as");
    }

    private static void testCommand(){
        GUI gui = new GUI();
        gui.clickButton();
    }
}
