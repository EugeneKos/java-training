package ru.eugene.java.learn.chain;

public abstract class StartServiceChain {
    private StartServiceChain next;

    public StartServiceChain(StartServiceChain next) {
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
