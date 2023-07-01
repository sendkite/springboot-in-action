package com.example.todos.web;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.slf4j.Logger;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public WebMvcConfiguration() {
        logger.debug("스프링 MVC 설정자 생성");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 리소스 핸들러 등록
//        registry.addResourceHandler("/assets/**")
//                .addResourceLocations("");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // registry.enableContentNegotiation();
        // 위와 같이 직접 설정하면, 스프링부트가 구성한 ContentNegotiatingViewResolver 전략이 무시된다.
        registry.viewResolver(new TodoController.TodoViewResolver());
    }

    public static class ContentNegotiationCustomizer {

        public void configurer(ContentNegotiatingViewResolver viewResolver) {
            // TODO ContentNegotiatingViewResolver 사용자 정의
        }
    }
}
