package ru.eugene.java.learn.service.impl;

import ru.eugene.java.learn.common.CommonResource;
import ru.eugene.java.learn.service.ThreadService;
import ru.eugene.java.learn.thread.IncrementMaster;

public class IncrementMasterService implements ThreadService {
    private final boolean syncFlag;

    public IncrementMasterService(boolean syncFlag) {
        this.syncFlag = syncFlag;
    }

    @Override
    public void doIt(){
        System.out.println(Thread.currentThread().getName() + " start work");

        CommonResource commonResource = new CommonResource();

        Thread thread1 = new Thread(new IncrementMaster(commonResource, syncFlag));
        Thread thread2 = new Thread(new IncrementMaster(commonResource, syncFlag));
        Thread thread3 = new Thread(new IncrementMaster(commonResource, syncFlag));
        Thread thread4 = new Thread(new IncrementMaster(commonResource, syncFlag));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            // Остановит поток main пока не отработает thread1
            thread1.join();
            // Остановит поток main пока не отработает thread2
            thread2.join();
            // Остановит поток main пока не отработает thread3
            thread3.join();
            // Остановит поток main пока не отработает thread4
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int commonResourceNum = commonResource.getNum();
        System.out.println("common resource num = " + commonResourceNum);
        if(commonResource.getNum() != 4000){
            System.out.println("error count: " + (4000 - commonResourceNum));
        }
        System.out.println(Thread.currentThread().getName() + " finish work");
    }
}
