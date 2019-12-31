package ru.eugene.java.learn.gc;

import java.util.LinkedList;
import java.util.List;

public class GcTask1 {
    private static final int MULTIPLIER = 1024;
    private static final int BYTE_NUM = 2;

    private List<byte[]> bytes = new LinkedList<>();

    public void start(){
        while (true){
            bytes.add(new byte[BYTE_NUM * MULTIPLIER * MULTIPLIER]);
            int size = bytes.size();
            System.out.println("size: " + BYTE_NUM * size + " MB :: list size: " + size);
            delay(200);
            if(size >= 500){
                bytes.clear();
                System.out.println("****************** clear list ******************");
            }
        }
    }

    private void delay(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
