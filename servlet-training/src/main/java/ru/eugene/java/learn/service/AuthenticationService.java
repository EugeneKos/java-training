package ru.eugene.java.learn.service;

import ru.eugene.java.learn.exception.AuthenticationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthenticationService {
    boolean isAuthenticated(HttpServletRequest request);
    void authentication(String login, String password, HttpServletResponse response) throws AuthenticationException;
    void logout(HttpServletRequest request, HttpServletResponse response);
}
