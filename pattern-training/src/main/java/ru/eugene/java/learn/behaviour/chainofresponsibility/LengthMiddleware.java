package ru.eugene.java.learn.behaviour.chainofresponsibility;

public class LengthMiddleware extends Middleware {
    public LengthMiddleware(Middleware next) {
        super(next);
    }

    @Override
    public boolean check(String message) {
        if(message.length() >= 8){
            System.out.println("check length true");
            return nextCheck(message);
        }
        System.err.println("check length false");
        return false;
    }
}
