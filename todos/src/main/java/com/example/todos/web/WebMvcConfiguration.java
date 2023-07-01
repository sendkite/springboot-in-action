package com.example.todos.web;

import com.example.todos.commons.web.view.CommaSeparatedValuesView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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

    @Bean(name = "todos")
    public CommaSeparatedValuesView todoCsvView() {
        return new CommaSeparatedValuesView();
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
//         registry.enableContentNegotiation(new CommaSeparatedValuesView());
        // 위와 같이 직접 설정하면, 스프링부트가 구성한 ContentNegotiatingViewResolver 전략이 무시된다. 사용에 주의
//        registry.viewResolver(new TodoController.TodoViewResolver());
    }

//    @Configuration
//    public static class ContentNegotiationCustomizer {
        // todo : Autowired로 디폴트뷰 구성하면 rest api 동작안함
//
//        @Autowired
//        public void configurer(ContentNegotiatingViewResolver viewResolver) {
//            List<View> defaultViews = new ArrayList<>(viewResolver.getDefaultViews());
//            defaultViews.add(new CommaSeparatedValuesView());
//            defaultViews.add(new MappingJackson2JsonView());
//
//            viewResolver.setDefaultViews(defaultViews);
//        }
//    }
}
