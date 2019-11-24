package ru.eugene.java.learn.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.eugene.java.learn.data.User;
import ru.eugene.java.learn.service.IUserService;

@Component
public class Mutation implements GraphQLMutationResolver {
    private IUserService userService;

    @Autowired
    public Mutation(IUserService userService) {
        this.userService = userService;
    }

    public User createUser(Long id, String name, String surname){
        return userService.create(id, name, surname);
    }
}
