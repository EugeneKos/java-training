package ru.eugene.java.learn.chain;

import ru.eugene.java.learn.service.IncrementMasterService;

public class IncrementMasterChain extends ServiceChain {
    private IncrementMasterService service;

    public IncrementMasterChain(ServiceChain next, IncrementMasterService service) {
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
