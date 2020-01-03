package ru.eugene.java.learn.service;

import ru.eugene.java.learn.service.impl.AuthenticationServiceImpl;
import ru.eugene.java.learn.service.impl.PersonServiceImpl;

public final class ServiceContext {
    private static PersonService personService = new PersonServiceImpl();
    private static AuthenticationService authenticationService = new AuthenticationServiceImpl(personService);

    private ServiceContext(){}

    public static PersonService getPersonService() {
        return personService;
    }

    public static AuthenticationService getAuthenticationService(){
        return authenticationService;
    }
}
