package ru.eugene.java.learn;

import ru.eugene.java.learn.chain.Argument;
import ru.eugene.java.learn.chain.FillPullChain;
import ru.eugene.java.learn.chain.IncrementMasterChain;
import ru.eugene.java.learn.chain.StartServiceChain;
import ru.eugene.java.learn.service.impl.FillPullService;
import ru.eugene.java.learn.service.impl.IncrementMasterService;

public class App {
    public static void main(String[] args) {
        StartServiceChain chain = getChain();
        chain.startService(Argument.SC);
    }

    private static StartServiceChain getChain(){
        return new IncrementMasterChain(new FillPullChain(null, new FillPullService()), new IncrementMasterService(false));
    }
}
