package com.example.helloService.hello;

public class APIHello implements Hello {

    @Override
    public void sayHello(String name) {
        System.out.println("Ciao, benvenuto " + name);
    }
}
