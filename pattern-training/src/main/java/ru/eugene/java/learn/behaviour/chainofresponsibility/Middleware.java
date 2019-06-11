package ru.eugene.java.learn.behaviour.chainofresponsibility;

public abstract class Middleware {
    private Middleware next;

    public Middleware(Middleware next) {
        this.next = next;
    }

    public abstract String getName();

    public abstract boolean checkMe(String message);

    public boolean check(String message){
        // fixme : Цепочка не работает
        if(checkMe(message)){
            System.out.println("check " + getName() + " true");
            return checkNext(message);
        } else {
            System.err.println("check " + getName() + " false");
            return false;
        }
    }

    private boolean checkNext(String message){
        if(next == null){
            return true;
        }
        return next.checkMe(message);
    }


}
