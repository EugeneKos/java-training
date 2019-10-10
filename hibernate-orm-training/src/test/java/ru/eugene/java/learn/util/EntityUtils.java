package ru.eugene.java.learn.util;

import ru.eugene.java.learn.data.Automobile;
import ru.eugene.java.learn.data.Person;

public final class EntityUtils {
    private EntityUtils(){}

    public static Person createPerson(String name, String surname, String code){
        Person person = new Person();
        person.setName(name);
        person.setSurname(surname);
        person.setLogin(code);
        return person;
    }

    public static Automobile createAutomobile(String mark, String model, String stateNumber){
        Automobile automobile = new Automobile();
        automobile.setMark(mark);
        automobile.setModel(model);
        automobile.setStateNumber(stateNumber);
        return automobile;
    }
}
