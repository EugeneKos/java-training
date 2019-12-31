package ru.eugene.java.learn.periodic.task;

import ru.eugene.java.learn.periodic.PeriodicTaskManagement;

public abstract class AbstractPeriodicTask implements Runnable {
    private String identify;

    private PeriodicTaskManagement taskManagement;

    public AbstractPeriodicTask(String identify, PeriodicTaskManagement taskManagement) {
        this.identify = identify;
        this.taskManagement = taskManagement;
    }

    public String getIdentify() {
        return identify;
    }

    public abstract void perform() throws Exception;

    @Override
    public void run() {
        try {
            perform();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            taskManagement.removeTask(this);
        }
    }
}
