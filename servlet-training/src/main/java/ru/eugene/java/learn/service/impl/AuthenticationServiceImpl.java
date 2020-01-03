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
        Cookie[] cookies = request.getCookies();
        if(cookies == null){
            return false;
        }

        for (Cookie cookie : cookies){
            if("_lp".equals(cookie.getName())){
                String cookieValue = cookie.getValue();
                String[] loginPassword = cookieValue.split(":");

                Person person = personService.getByLogin(loginPassword[0]);

                if(person != null && person.getPassword().equals(loginPassword[1])){
                    HttpSession session = request.getSession();

                    if(session.getAttribute("personLogin") == null){
                        session.setAttribute("personLogin", loginPassword[0]);
                    }

                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public void authentication(String login, String password, HttpServletResponse response) throws AuthenticationException {
        Person person = personService.getByLogin(login);
        if(person != null && person.getPassword().equals(password)){
            Cookie lpCookie = new Cookie("_lp", login + ":" + password);
            lpCookie.setSecure(false);
            lpCookie.setMaxAge(3600 * 24 * 7);

            response.addCookie(lpCookie);
        } else {
            throw new AuthenticationException("Authentication failed");
        }
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies){
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
    }
}
