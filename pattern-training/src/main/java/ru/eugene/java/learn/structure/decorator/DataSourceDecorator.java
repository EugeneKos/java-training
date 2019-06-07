package ru.eugene.java.learn.structure.decorator;

/**
 * Суть паттерна декоратор, накручиваем дополнительную логику, оборачивая оригинальный объект.
 * Можно сделать несколько декораторов с помощью наследования для реализации другой дополниткльной логики
 * Например следующий декоратор может сжимать данные прежде чем их сохранить.
 */
public class DataSourceDecorator {
    private DataSourceExample dataSourceExample;

    public DataSourceDecorator(DataSourceExample dataSourceExample) {
        this.dataSourceExample = dataSourceExample;
    }

    public void save(){
        /*
         * Накручиваем дополнительную логику
         * Например перед сохраненим данных мы хотим их зашифровать
         */
        dataSourceExample.save();
    }

    public void delete(){
        /*
         * Накручиваем дополнительную логику
         */
        dataSourceExample.delete();
    }
}
