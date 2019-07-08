package ru.eugene.java.learn.common;

/**
 * Общий ресурс, с которым произходят операции в разных потоках
 */
public class CommonResource {
    private int num;

    public void incrementNum(){
        num++;
    }

    public int getNum() {
        return num;
    }
}
