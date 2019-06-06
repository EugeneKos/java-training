package ru.eugene.java.learn.generator.singleton;

/**
 * Смысл паттерна singleton, чтобы объект был в единственном экземпляре
 */
public class DataSource {
    private volatile static DataSource dataSource;

    private DataSource(){}

    public static DataSource getInstance(){
        if(dataSource == null){
            // fixme : Разобраться с double check
            synchronized (DataSource.class){
                if(dataSource == null){
                    dataSource = new DataSource();
                }
            }
        }
        return dataSource;
    }
}
