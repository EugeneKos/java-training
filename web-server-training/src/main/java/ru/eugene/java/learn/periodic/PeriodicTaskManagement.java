package ru.eugene.java.learn.periodic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import ru.eugene.java.learn.periodic.task.AbstractPeriodicTask;
import ru.eugene.java.learn.periodic.task.SomePeriodicTask;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PeriodicTaskManagement {
    private ThreadPoolTaskExecutor taskExecutor;

    private Map<String, AbstractPeriodicTask> tasks = new ConcurrentHashMap<>();

    @Autowired
    public PeriodicTaskManagement(ThreadPoolTaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    @Scheduled(fixedDelay = 3 * 1000)
    public void initSomeTask(){
        SomePeriodicTask somePeriodicTask = new SomePeriodicTask("123456", this);
        executeTask(somePeriodicTask);
    }

    private void executeTask(AbstractPeriodicTask task){
        if(tasks.containsKey(task.getIdentify())){
            return;
        }
        tasks.put(task.getIdentify(), task);
        taskExecutor.execute(task);
    }

    public void removeTask(AbstractPeriodicTask task){
        tasks.remove(task.getIdentify());
    }
}
