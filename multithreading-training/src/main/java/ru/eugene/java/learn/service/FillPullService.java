package ru.eugene.java.learn.service;

import ru.eugene.java.learn.common.CommonResource;
import ru.eugene.java.learn.common.Counter;
import ru.eugene.java.learn.thread.Filling;
import ru.eugene.java.learn.thread.Pulling;

public class FillPullService {
    public void doIt(){
        CommonResource commonResource = new CommonResource();
        Counter counter = new Counter(1000);

        Filling filling = new Filling(commonResource, counter);
        Pulling pulling = new Pulling(commonResource, counter);

        filling.start();
        pulling.start();

        try {
            filling.join();
            pulling.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Total common resource num: " + commonResource.getNum());
        System.out.println("Total counter: " + counter.getCount());
    }
}
