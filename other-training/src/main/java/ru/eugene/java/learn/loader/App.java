package ru.eugene.java.learn.loader;

import ru.eugene.java.learn.loader.logic.LogicClass1;
import ru.eugene.java.learn.loader.logic.LogicClass2;
import ru.eugene.java.learn.loader.logic.LogicClass3;

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        LogicClass1 logicClass1 = new LogicClass1();
        logicClass1.sayHello();

        try {
            Class logicClass2Class = Class.forName("ru.eugene.java.learn.loader.logic.LogicClass2");
            Object instance = logicClass2Class.newInstance();
            if(instance instanceof LogicClass2){
                LogicClass2 logicClass2 = (LogicClass2) instance;
                logicClass2.printInfo("My info");
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        LogicClass3 logicClass3 = new LogicClass3();
        logicClass3.printList(new ArrayList<>(Arrays.asList(
                "Hello", "My", "App"
        )));
    }
}
