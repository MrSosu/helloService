package com.example.helloService.controllers;

import com.example.helloService.hello.Hello;
import com.example.helloService.hello.PrototypeOutHello;
import com.example.helloService.hello.StandardOutHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scope")
public class BeanScopeController {

    @Autowired
    private ApplicationContext context;

    /* bad practice */
    @GetMapping("/singleton")
    public void testSingletonScope() {
        System.out.println("BEAN SINGLETON");
        Hello hello = context.getBean(StandardOutHello.class);
        Hello hello1 = context.getBean(StandardOutHello.class);
        hello.sayHello("Marco");
        hello1.sayHello("Marco");
        System.out.println(hello);
        System.out.println(hello1);
    }

    @GetMapping("/prototype")
    public void testPrototypeScope() {
        System.out.println("BEAN PROTOTYPE");
        PrototypeOutHello hello1 = context.getBean(PrototypeOutHello.class);
        PrototypeOutHello hello2 = context.getBean(PrototypeOutHello.class);
        System.out.println(hello1);
        System.out.println(hello2);
        System.out.println(hello1.getStandardOutHello());
        System.out.println(hello2.getStandardOutHello());
    }

}
