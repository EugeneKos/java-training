package ru.eugene.java.learn.http.filter;

import ru.eugene.java.learn.service.AuthenticationService;
import ru.eugene.java.learn.service.ServiceContext;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(servletNames = "main")
public class AuthenticationFilter extends HttpFilter {
    private static final long serialVersionUID = -2154531701018703758L;

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        AuthenticationService authenticationService = ServiceContext.getAuthenticationService();

        if(authenticationService.isAuthenticated(request)){
            chain.doFilter(request, response);
            return;
        }

        request.getRequestDispatcher("/WEB-INF/views/authentication.jsp").forward(request, response);

    }
}
