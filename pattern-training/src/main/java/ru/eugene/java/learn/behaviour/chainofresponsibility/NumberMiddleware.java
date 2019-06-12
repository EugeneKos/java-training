package ru.eugene.java.learn.behaviour.chainofresponsibility;

public class NumberMiddleware extends Middleware {
    public NumberMiddleware(Middleware next) {
        super(next);
    }

    @Override
    public boolean check(String message) {
        if(message.matches(".*\\d+.*")){
            System.out.println("check contains number true");
            return nextCheck(message);
        }
        System.err.println("check contains number false");
        return false;
    }
}
