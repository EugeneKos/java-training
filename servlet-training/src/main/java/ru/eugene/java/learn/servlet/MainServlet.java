package ru.eugene.java.learn.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 6522445166508844509L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        Integer numberOfVisit = (Integer) session.getAttribute("numberOfVisit");
        if(numberOfVisit == null){
            numberOfVisit = 1;
        } else {
            numberOfVisit ++;
        }

        session.setAttribute("numberOfVisit", numberOfVisit);

        PrintWriter writer = response.getWriter();
        writer.println("Hello Servlet. Number of visit: " + numberOfVisit);
        writer.println("Last Accessed Time: " + new Date(session.getLastAccessedTime()));
        writer.println("Max Inactive Interval: " + new Date(session.getMaxInactiveInterval()));
    }
}
