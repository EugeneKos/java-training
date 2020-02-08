package ru.eugene.java.learn.http.servlet;

import ru.eugene.java.learn.service.AuthenticationService;
import ru.eugene.java.learn.service.ServiceContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 4099390464777045971L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AuthenticationService authenticationService = ServiceContext.getAuthenticationService();
        authenticationService.logout(request, response);

        response.sendRedirect("auth");
    }
}
