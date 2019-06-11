package ru.eugene.java.learn.behaviour;

import ru.eugene.java.learn.behaviour.chainofresponsibility.MessageChecker;

public class BehaviourMain {
    public static void main(String[] args) {
        testChainOfResponsibility();
    }

    private static void testChainOfResponsibility(){
        MessageChecker messageChecker = new MessageChecker();
        messageChecker.checkMessage("ckffkfdfefeteASDSS");
    }
}
