package ru.eugene.java.learn.chain;

import ru.eugene.java.learn.service.ThreadService;

public class IncrementMasterChain extends StartServiceChain {
    private ThreadService service;

    public IncrementMasterChain(StartServiceChain next, ThreadService service) {
        super(next);
        this.service = service;
    }

    @Override
    public void startService(Argument argument) {
        if(argument == Argument.SC){
            service.doIt();
        } else {
            next(argument);
        }
    }
}
