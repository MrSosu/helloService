package com.example.helloService.configurations;

import com.example.helloService.hello.APIHello;
import com.example.helloService.hello.Hello;
import com.example.helloService.hello.PrototypeOutHello;
import com.example.helloService.hello.StandardOutHello;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean("salve")
    public Hello hello() {
        return new StandardOutHello("Salve!");
    }

    @Bean("bella")
    @Primary
    public Hello hello2() {
        return new StandardOutHello("Bella!");
    }

    @Bean("api")
    public APIHello apiHello() { return new APIHello(); }

    @Bean
    @Scope(scopeName = "prototype")
    public PrototypeOutHello protoHello() { return new PrototypeOutHello(); }

}
