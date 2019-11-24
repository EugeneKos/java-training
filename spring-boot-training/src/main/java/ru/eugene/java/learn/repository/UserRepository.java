package ru.eugene.java.learn.repository;

import org.springframework.stereotype.Service;

import ru.eugene.java.learn.data.User;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserRepository {
    private Set<User> users;

    @PostConstruct
    private void init(){
        users = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            users.add(new User(Long.valueOf("" + i), "name_" + i, "surname_" + i));
        }
    }

    public Set<User> findAll(){
        return users;
    }

    public User findById(Long id){
        for (User user : users){
            if(user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }

    public User save(User user){
        users.add(user);
        return user;
    }
}
