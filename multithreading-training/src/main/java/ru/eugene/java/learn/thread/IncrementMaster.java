package ru.eugene.java.learn.thread;

import ru.eugene.java.learn.common.CommonResource;

public class IncrementMaster implements Runnable {
    private final CommonResource commonResource;
    private final boolean synchronizedFlag;

    public IncrementMaster(CommonResource commonResource, boolean synchronizedFlag) {
        this.commonResource = commonResource;
        this.synchronizedFlag = synchronizedFlag;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start work");
        int count = 0;
        while (count < 1000){
            if(synchronizedFlag){
                incrementWithSynchronized();
            } else {
                incrementWithoutSynchronized();
            }
            count++;
        }
        System.out.println(Thread.currentThread().getName() + " finish work");
    }

    /**
     * Используем synchronized блок, в его параметры передаем объект над которым совершаются
     * операции в многопоточной программе.
     */
    private void incrementWithSynchronized(){
        synchronized (commonResource){
            commonResource.incrementNum();
        }
    }

    /**
     * Не используем synchronized блок.
     */
    private void incrementWithoutSynchronized(){
        commonResource.incrementNum();
    }
}
