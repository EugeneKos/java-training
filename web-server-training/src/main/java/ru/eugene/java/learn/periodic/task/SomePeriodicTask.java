package ru.eugene.java.learn.periodic.task;

import ru.eugene.java.learn.periodic.PeriodicTaskManagement;

import java.time.LocalDateTime;

public class SomePeriodicTask extends AbstractPeriodicTask {
    public SomePeriodicTask(String identify, PeriodicTaskManagement taskManagement) {
        super(identify, taskManagement);
    }

    @Override
    public void perform() throws Exception {
        System.out.println("Do It!!!! Time: " + LocalDateTime.now());
        Thread.sleep(15000);
    }
}
