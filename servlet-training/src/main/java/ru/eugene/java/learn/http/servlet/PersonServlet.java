package ru.eugene.java.learn.http.servlet;

import ru.eugene.java.learn.data.Person;
import ru.eugene.java.learn.service.PersonService;
import ru.eugene.java.learn.service.ServiceContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

public class PersonServlet extends HttpServlet {
    private static final long serialVersionUID = 639396725771348499L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String personLogin = (String) session.getAttribute("personLogin");

        PersonService personService = ServiceContext.getPersonService();
        Person person = personService.getByLogin(personLogin);
        person.setNumberOfVisit(person.getNumberOfVisit() + 1);

        request.setAttribute("personFirstName", person.getFirstName());
        request.setAttribute("personLastName", person.getLastName());
        request.setAttribute("personLogin", person.getLogin());
        request.setAttribute("personNumOfVisit", person.getNumberOfVisit());

        request.getRequestDispatcher("/WEB-INF/views/person.jsp").forward(request, response);
    }
}
