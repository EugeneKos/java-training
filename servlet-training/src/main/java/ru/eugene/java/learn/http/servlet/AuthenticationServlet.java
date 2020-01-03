package ru.eugene.java.learn.http.servlet;

import ru.eugene.java.learn.exception.AuthenticationException;
import ru.eugene.java.learn.service.AuthenticationService;
import ru.eugene.java.learn.service.ServiceContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

public class AuthenticationServlet extends HttpServlet {
    private static final long serialVersionUID = 6959517331172456696L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();

        AuthenticationService authenticationService = ServiceContext.getAuthenticationService();

        try {
            authenticationService.authentication(login, password, response);
            session.setAttribute("personLogin", login);
            response.sendRedirect("person");
        } catch (AuthenticationException e) {
            request.getRequestDispatcher("/WEB-INF/views/authentication.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AuthenticationService authenticationService = ServiceContext.getAuthenticationService();

        if(authenticationService.isAuthenticated(request)){
            response.sendRedirect("person");
            return;
        }

        request.getRequestDispatcher("/WEB-INF/views/authentication.jsp").forward(request, response);
    }
}
