package ru.eugene.java.learn.behaviour.chainofresponsibility;

public class LengthMiddleware extends Middleware {
    public LengthMiddleware(Middleware next) {
        super(next);
    }

    @Override
    public String getName() {
        return "message length";
    }

    @Override
    public boolean checkMe(String message) {
        return message.length() >= 8;
    }
}
