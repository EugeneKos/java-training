package ru.eugene.java.learn.thread;

import ru.eugene.java.learn.common.CommonResource;
import ru.eugene.java.learn.common.Counter;

public class Filling extends Thread {
    private final CommonResource commonResource;
    private final Counter counter;

    public Filling(CommonResource commonResource, Counter counter) {
        setName("filling");
        this.commonResource = commonResource;
        this.counter = counter;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start work");
        while (counter.getCount() > 0){
            synchronized (commonResource){
                if(commonResource.getNum() >= 100){
                    commonResource.notify();
                    try {
                        commonResource.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    commonResource.incrementNum();
                    System.out.println(Thread.currentThread().getName() +
                            " increment, current value: " + commonResource.getNum());
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (counter){
                if(counter.getCount() > 0){
                    counter.decrement();
                }
            }
        }
        synchronized (commonResource){
            commonResource.notifyAll();
        }
        System.out.println(Thread.currentThread().getName() + " finish work");
    }
}
