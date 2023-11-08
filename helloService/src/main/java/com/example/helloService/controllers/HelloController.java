package com.example.helloService.controllers;

import com.example.helloService.hello.APIHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private APIHello apiHello;

    @GetMapping("/")
    public void helloMan(@RequestParam(name = "name") String name) {
        apiHello.sayHello(name);
    }

}
