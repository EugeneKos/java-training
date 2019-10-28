package ru.eugene.java.learn.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.eugene.java.learn.service.IExampleMBeanService;

@RestController()
@RequestMapping(path = "/rest")
public class ExampleMBeanController {
    private IExampleMBeanService exampleMBeanService;

    @Autowired
    public ExampleMBeanController(IExampleMBeanService exampleMBeanService) {
        this.exampleMBeanService = exampleMBeanService;
    }

    @GetMapping("/map/update")
    public void updateMap(){
        exampleMBeanService.updateMap();
    }
}
