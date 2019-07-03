package ru.eugene.java.learn.repository;

import org.springframework.data.repository.CrudRepository;
import ru.eugene.java.learn.data.Module;

public interface ModuleRepository extends CrudRepository<Module, Long> {
}
