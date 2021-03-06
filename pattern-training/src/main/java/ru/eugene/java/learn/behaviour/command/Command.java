package ru.eugene.java.learn.behaviour.command;

/**
 * Интерфейс команда с единственным методом выполнения команды.
 * Класс которые реализуют этот интерфейс будует получать класс бизнес-логики
 * и параметры для бизнес логики
 *
 * Команда превращает операции в объекты.
 * А объекты можно передавать, хранить и взаимозаменять внутри других объектов.
 *
 * Паттерн может применяться для отмены команды (операции)
 */
public interface Command {
    void execute();
}
