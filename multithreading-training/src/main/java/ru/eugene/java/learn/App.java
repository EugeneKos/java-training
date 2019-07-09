package ru.eugene.java.learn;

import ru.eugene.java.learn.chain.Argument;
import ru.eugene.java.learn.chain.FillPullChain;
import ru.eugene.java.learn.chain.IncrementMasterChain;
import ru.eugene.java.learn.chain.ServiceChain;
import ru.eugene.java.learn.service.FillPullService;
import ru.eugene.java.learn.service.IncrementMasterService;

public class App {
    public static void main(String[] args) {
        start(Argument.WN);
    }

    private static void start(Argument argument){
        ServiceChain chain = getChain();
        chain.startService(argument);
    }

    private static ServiceChain getChain(){
        FillPullChain fillPullChain = new FillPullChain(null, new FillPullService());
        return new IncrementMasterChain(fillPullChain, new IncrementMasterService(false));
    }
}
