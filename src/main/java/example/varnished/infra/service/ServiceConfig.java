package example.varnished.infra.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import example.varnished.app.example.ExampleService;

@Configuration
public class ServiceConfig {

    @Bean
    public ExampleService exampleService() {
        return new ExampleService();
    }
}
