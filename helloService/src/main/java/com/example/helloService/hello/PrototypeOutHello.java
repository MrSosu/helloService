package com.example.helloService.hello;

import org.springframework.beans.factory.annotation.Autowired;

public class PrototypeOutHello implements Hello {

    @Autowired
    private StandardOutHello standardOutHello;



    @Override
    public void sayHello(String name) {
        System.out.println("Ciao sono un prototype bean");
    }

    public StandardOutHello getStandardOutHello() {
        return standardOutHello;
    }
}
