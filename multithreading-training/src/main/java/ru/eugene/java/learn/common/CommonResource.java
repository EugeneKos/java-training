package ru.eugene.java.learn.common;

/**
 * Общий ресурс, с которым произходят операции в разных потоках
 */
public class CommonResource {
    private int num;

    public void incrementNum(){
        num++;
    }

    public void decrement(){
        if(num == 0){
            throw new UnsupportedOperationException("decrement operation impossible num = " + num);
        }
        num--;
    }

    public int getNum() {
        return num;
    }
}
