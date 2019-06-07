package ru.eugene.java.learn.structure.adapter;

/**
 * Класс обработки супер запросов
 */
public class SuperHandler {
    public String handle(SuperRequest superRequest){
        /*
         * Логика обработки супер запроса
         */
        return superRequest.getHeader() + "::::" + superRequest.getBody() + " ready !!!";
    }
}
