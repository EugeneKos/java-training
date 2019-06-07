package ru.eugene.java.learn.structure.decorator;

public class DataSourceExampleImpl implements DataSourceExample {
    @Override
    public void save() {
        System.out.println("save data");
    }

    @Override
    public void delete() {
        System.out.println("delete data");
    }
}
