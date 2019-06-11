package ru.eugene.java.learn.behaviour.chainofresponsibility;

public class MessageChecker {
    public void checkMessage(String message){
        Middleware middleware = new LengthMiddleware(new UpperCaseMiddleware(new NumberMiddleware(null)));
        middleware.check(message);
    }
}
