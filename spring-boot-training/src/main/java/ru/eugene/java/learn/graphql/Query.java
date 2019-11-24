package ru.eugene.java.learn.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.eugene.java.learn.data.User;
import ru.eugene.java.learn.service.IUserService;

@Component
public class Query implements GraphQLQueryResolver {
    private IUserService userService;

    @Autowired
    public Query(IUserService userService) {
        this.userService = userService;
    }

    public User getById(Long id){
        return userService.getById(id);
    }
}
