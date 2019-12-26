package ru.eugene.java.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import ru.eugene.java.learn.periodic.PeriodicTaskManagement;

@Configuration
@EnableScheduling
public class PeriodicTaskConfiguration {
    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(3);
        taskExecutor.setMaxPoolSize(5);
        return taskExecutor;
    }

    @Bean
    public PeriodicTaskManagement periodicTaskManagement(ThreadPoolTaskExecutor taskExecutor){
        return new PeriodicTaskManagement(taskExecutor);
    }
}
