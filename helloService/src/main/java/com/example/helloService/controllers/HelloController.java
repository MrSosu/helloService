package com.example.helloService.controllers;


import com.example.helloService.hello.APIHello;
import com.example.helloService.hello.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

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
