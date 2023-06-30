package com.example.todos;

import com.example.todos.web.model.SiteProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ConfigurationPropertiesScan
public class TodosApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodosApplication.class, args);
    }

    @Bean
    public SiteProperties siteProperties() {
        return new SiteProperties();
    }
}
