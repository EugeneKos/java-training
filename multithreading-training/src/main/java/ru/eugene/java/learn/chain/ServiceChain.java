package ru.eugene.java.learn.chain;

public abstract class ServiceChain {
    private ServiceChain next;

    public ServiceChain(ServiceChain next) {
        this.next = next;
    }

    public abstract void startService(Argument argument);

    void next(Argument argument){
        if(next == null){
            System.out.println("chain of end");
            return;
        }
        next.startService(argument);
    }
}
