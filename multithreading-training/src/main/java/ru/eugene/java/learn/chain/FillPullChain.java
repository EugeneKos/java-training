package ru.eugene.java.learn.chain;

import ru.eugene.java.learn.service.FillPullService;

public class FillPullChain extends ServiceChain {
    private FillPullService service;

    public FillPullChain(ServiceChain next, FillPullService service) {
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
