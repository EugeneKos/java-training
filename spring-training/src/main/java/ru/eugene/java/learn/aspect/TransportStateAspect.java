package ru.eugene.java.learn.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class TransportStateAspect {
    public void checkTransport(){
        System.out.println("check transport");
    }

    public void watchPerformance(ProceedingJoinPoint joinpoint){
        try {
            long start = System.currentTimeMillis();
            joinpoint.proceed();
            long end = System.currentTimeMillis();
            System.out.println("The performance took " + (end - start)
                    + " milliseconds.");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
