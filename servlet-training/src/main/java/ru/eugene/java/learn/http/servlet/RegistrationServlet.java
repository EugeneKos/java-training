package ru.eugene.java.learn.http.servlet;

import ru.eugene.java.learn.exception.PersonAlreadyExistException;
import ru.eugene.java.learn.service.PersonService;
import ru.eugene.java.learn.service.ServiceContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 5268180314909001144L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        PrintWriter writer = response.getWriter();

        PersonService personService = ServiceContext.getPersonService();

        try {
            personService.create(firstName, lastName, login, password);
            writer.println("Registration successful.");
        } catch (PersonAlreadyExistException e) {
            writer.println("Registration failed.");
            writer.println("Detail: " + e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(request, response);
    }
}
