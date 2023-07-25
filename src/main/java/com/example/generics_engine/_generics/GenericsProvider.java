package com.example.generics_engine._generics;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenericsProvider {
    @Bean
    public <Model, Id> Port<Model, Id> port(GenericRepository<Model, Id> repository) {
        return new Port<Model, Id>(repository) {};
    }

}
