package ru.eugene.java.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ru.eugene.java.learn.dao.GroupDao;

import javax.persistence.EntityManager;

@Configuration
@Import({DataConfiguration.class})
public class DomainConfiguration {
    @Bean
    public GroupDao groupDao(EntityManager entityManager){
        return new GroupDao(entityManager);
    }
}
