package ru.eugene.java.learn.behaviour.chainofresponsibility;

public class MessageChecker {
    public void checkMessage(String message){
        Middleware middleware = new LengthMiddleware(new UpperCaseMiddleware(new NumberMiddleware(null)));
        boolean resultCheck = middleware.check(message);
        if(resultCheck){
            System.out.println("full check message true");
        } else {
            System.err.println("full check message false");
        }
    }
}
