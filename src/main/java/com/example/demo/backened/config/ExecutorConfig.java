package com.example.demo.backened.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExecutorConfig {
     @Bean
    public ExecutorService executorService() {
        // Fixed thread pool of 5 threads
        return Executors.newFixedThreadPool(5);
    }
}
