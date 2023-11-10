package com.example.helloService.hello;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class APIHello implements Hello {

    @Override
    public void sayHello(String name) {
        System.out.println("Ciao, benvenuto " + name);
    }


}
