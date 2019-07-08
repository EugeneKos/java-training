package ru.eugene.java.learn.chain;

import ru.eugene.java.learn.service.ThreadService;

public class FillPullChain extends StartServiceChain {
    private ThreadService service;

    public FillPullChain(StartServiceChain next, ThreadService service) {
        super(next);
        this.service = service;
    }

    @Override
    public void startService(Argument argument) {
        if(argument == Argument.WN){
            service.doIt();
        } else {
            next(argument);
        }
    }
}
