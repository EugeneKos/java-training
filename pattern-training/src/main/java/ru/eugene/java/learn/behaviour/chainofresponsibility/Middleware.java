package ru.eugene.java.learn.behaviour.chainofresponsibility;

public abstract class Middleware {
    private Middleware next;

    public Middleware(Middleware next) {
        this.next = next;
    }

    public abstract boolean check(String message);

    protected boolean nextCheck(String message){
        if(next == null){
            return true;
        }
        return next.check(message);
    }


}
