package ru.eugene.java.learn.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.eugene.java.learn.service.IExampleCacheService;

@RestController()
@RequestMapping(path = "/rest")
public class ExampleCacheController {
    private IExampleCacheService exampleCacheService;

    @Autowired
    public ExampleCacheController(IExampleCacheService exampleCacheService) {
        this.exampleCacheService = exampleCacheService;
    }

    @GetMapping("/cache/{name}/{surname}")
    public String perform(@PathVariable("name") String name, @PathVariable("surname") String surname){
        return exampleCacheService.perform(name, surname);
    }

    @GetMapping("/cache/fix")
    public String perform(){
        return exampleCacheService.perform();
    }
}
