package ru.eugene.java.learn.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.eugene.java.learn.service.IMainService;

@RestController()
@RequestMapping(path = "/rest")
public class PerformController {
    private IMainService mainService;

    @Autowired
    public PerformController(IMainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/cache/{name}/{surname}")
    public String perform(@PathVariable("name") String name, @PathVariable("surname") String surname){
        return mainService.perform(name, surname);
    }
}
