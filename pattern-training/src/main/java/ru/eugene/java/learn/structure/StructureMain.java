package ru.eugene.java.learn.structure;

import ru.eugene.java.learn.structure.adapter.SimpleRequest;
import ru.eugene.java.learn.structure.adapter.SuperHandler;
import ru.eugene.java.learn.structure.adapter.SuperRequestAdapter;
import ru.eugene.java.learn.structure.bridge.BasicRemote;
import ru.eugene.java.learn.structure.bridge.Device;
import ru.eugene.java.learn.structure.bridge.Remote;
import ru.eugene.java.learn.structure.bridge.TV;
import ru.eugene.java.learn.structure.decorator.DataSourceDecorator;
import ru.eugene.java.learn.structure.decorator.DataSourceExampleImpl;
import ru.eugene.java.learn.structure.facade.Facade;

public class StructureMain {
    public static void main(String[] args) {
        testAdapter();
        testBridge();
        testDecorator();
        testFacade();
    }

    private static void testAdapter(){
        SuperHandler superHandler = new SuperHandler();
        SuperRequestAdapter superRequestAdapter = new SuperRequestAdapter(new SimpleRequest());
        System.out.println(superHandler.handle(superRequestAdapter));
    }

    private static void testBridge(){
        Device deviceTv = new TV();
        Remote remote = new BasicRemote(deviceTv);
        remote.power();
        System.out.println(deviceTv.isEnable());
        remote.power();
        System.out.println(deviceTv.isEnable());
    }

    private static void testDecorator(){
        DataSourceDecorator dataSourceDecorator = new DataSourceDecorator(new DataSourceExampleImpl());
        dataSourceDecorator.save();
        dataSourceDecorator.delete();
    }

    private static void testFacade(){
        Facade facade = new Facade();
        facade.performHardLogic();
    }
}
