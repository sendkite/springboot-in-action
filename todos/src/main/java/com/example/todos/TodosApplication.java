package com.example.todos;

import com.example.todos.commons.web.error.ReadableErrorAttributes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ConfigurationPropertiesScan
public class TodosApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodosApplication.class, args);
    }

    @Bean
    public ReadableErrorAttributes readableErrorAttributes(MessageSource messageSource) {
        return new ReadableErrorAttributes(messageSource);
    }
}
