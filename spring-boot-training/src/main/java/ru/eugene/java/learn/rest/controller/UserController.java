package ru.eugene.java.learn.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.eugene.java.learn.data.User;
import ru.eugene.java.learn.service.IUserService;

import java.util.Set;

@RestController
@RequestMapping(path = "/rest/users", produces = "application/json")
public class UserController {
    private IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/getAll", method = RequestMethod.GET)
    public Set<User> getAllUsers(){
        return userService.getAll();
    }

    @RequestMapping(path = "/get/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") Long id){
        return userService.getById(id);
    }
}
