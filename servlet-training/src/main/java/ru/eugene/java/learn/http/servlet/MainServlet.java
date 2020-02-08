package ru.eugene.java.learn.http.servlet;

import ru.eugene.java.learn.data.Person;
import ru.eugene.java.learn.service.PersonService;
import ru.eugene.java.learn.service.ServiceContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "main", urlPatterns = "/main")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 6522445166508844509L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("login");

        PersonService personService = ServiceContext.getPersonService();
        Person person = personService.getByLogin(login);
        person.setNumberOfVisit(person.getNumberOfVisit() + 1);

        request.setAttribute("personFirstName", person.getFirstName());
        request.setAttribute("personLastName", person.getLastName());
        request.setAttribute("personLogin", person.getLogin());
        request.setAttribute("personNumOfVisit", person.getNumberOfVisit());

        request.getRequestDispatcher("/WEB-INF/views/person.jsp").forward(request, response);
    }
}
