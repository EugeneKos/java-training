package ru.eugene.java.learn.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.eugene.java.learn.service.IExampleMBeanService;

@RestController
@RequestMapping(path = "/rest/jmx", produces = "application/json")
public class ExampleMBeanController {
    private IExampleMBeanService exampleMBeanService;

    @Autowired
    public ExampleMBeanController(IExampleMBeanService exampleMBeanService) {
        this.exampleMBeanService = exampleMBeanService;
    }

    @RequestMapping(value = "/map/update", method = RequestMethod.GET)
    public void updateMap(){
        exampleMBeanService.updateMap();
    }
}
