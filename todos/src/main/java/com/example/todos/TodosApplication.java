package com.example.todos;

import com.example.todos.web.WebMvcConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodosApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodosApplication.class, args);
    }

    @Bean
    public WebMvcConfiguration todoappWebMvcConfiguration() {
        return new WebMvcConfiguration();
    }
}
