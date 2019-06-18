package ru.eugene.java.learn.behaviour.memento;

import java.util.LinkedList;

/**
 * Класс хранения истории снимков
 * @param <T> Класс снимка
 */
public class History<T> {
    private LinkedList<T> history = new LinkedList<>();

    public void push(T t){
        history.push(t);
    }

    public T undo(){
        if(history.size() == 0){
            return null;
        }
        return history.pop();
    }
}
