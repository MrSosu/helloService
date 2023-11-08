package com.example.helloService.components;

import com.example.helloService.hello.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class NewAppComponent implements CommandLineRunner {

    @Autowired
    @Qualifier("salve")
    private Hello hello;

    public NewAppComponent(Hello hello) {
        this.hello = hello;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Ciao sono il new app component");
        hello.sayHello("Marco");
    }
}
