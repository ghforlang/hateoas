package com.edu.nbu.cn.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilderFactory;

@Configuration
public class WebMvcLinkBuilderFactoryConfig {

    @Bean
    public WebMvcLinkBuilderFactory webMvcLinkBuilderFactory(){
//        return mock(WebMvcLinkBuilderFactory.class);
        return new WebMvcLinkBuilderFactory();
    }
}
