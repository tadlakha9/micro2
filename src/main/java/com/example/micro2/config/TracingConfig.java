package com.example.micro2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TracingConfig {

    @Bean
    public TracingFilter tracingFilter() {
        return new TracingFilter();
    }


}