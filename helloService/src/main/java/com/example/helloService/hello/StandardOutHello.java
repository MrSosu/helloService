package com.example.helloService.hello;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class StandardOutHello implements Hello {

    private final String greeting;

    public StandardOutHello(String greeting) {
        this.greeting = greeting;
    }

    @Override
    public void sayHello(String name) {
        System.out.println(greeting + " " + name);
    }

    @PostConstruct
    public void init() throws Exception {
        System.out.println("Ciao sono il Bean Standardout che è stato appena istanziato");
    }

    @PreDestroy
    public void destroy() throws Exception {
        System.out.println("ciao sono il Bean STandardout che è stato appena ucciso");
    }



}
