package ru.eugene.java.learn.behaviour.chainofresponsibility;

public class NumberMiddleware extends Middleware {
    public NumberMiddleware(Middleware next) {
        super(next);
    }

    @Override
    public String getName() {
        return "contains numbers";
    }

    @Override
    public boolean checkMe(String message) {

        return false;
    }
}
