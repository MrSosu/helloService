package com.example.helloService.components;

import com.example.helloService.hello.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppComponent implements CommandLineRunner {

    @Autowired
    private Hello hello;

    public AppComponent(Hello hello) {
        this.hello = hello;
    }

    @Override
    public void run(String... args) throws Exception {
        hello.sayHello("Marco");
    }
}
