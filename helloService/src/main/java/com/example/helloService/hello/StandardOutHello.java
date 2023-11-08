package com.example.helloService.hello;

public class StandardOutHello implements Hello {

    private final String greeting;

    public StandardOutHello(String greeting) {
        this.greeting = greeting;
    }

    @Override
    public void sayHello(String name) {
        System.out.println(greeting + " " + name);
    }
}
