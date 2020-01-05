package ru.eugene.java.learn.service.impl;

import ru.eugene.java.learn.data.Person;
import ru.eugene.java.learn.exception.AuthenticationException;
import ru.eugene.java.learn.service.AuthenticationService;
import ru.eugene.java.learn.service.PersonService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationServiceImpl implements AuthenticationService {
    private PersonService personService;

    public AuthenticationServiceImpl(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public boolean isAuthenticated(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Boolean auth = (Boolean) session.getAttribute("auth");
        return auth == null ? false : auth;
    }

    @Override
    public void authentication(String login, String password, HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        Person person = personService.getByLogin(login);
        if(person != null && person.getPassword().equals(password)){
            HttpSession session = request.getSession();
            session.setAttribute("login", login);
            session.setAttribute("auth", true);

            updateCookie(3600 * 24 * 7, request, response);
        } else {
            throw new AuthenticationException("Authentication failed");
        }
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.invalidate();
        updateCookie(0, request, response);
    }

    private void updateCookie(int maxAge, HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        if(cookies == null){
            return;
        }
        for(Cookie cookie : cookies){
            if("JSESSIONID".equals(cookie.getName())){
                cookie.setMaxAge(maxAge);
                response.addCookie(cookie);
            }
        }

    }
}
