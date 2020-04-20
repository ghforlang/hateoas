package com.edu.nbu.cn.configuration;

import com.edu.nbu.cn.common.BarResourceAssembler;
import com.edu.nbu.cn.common.FooResourceAssembler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class JsonConfiguration implements WebMvcConfigurer {

    @Bean
    public FooResourceAssembler fooResourceAssembler(){
        return new FooResourceAssembler();
    }

    @Bean
    public BarResourceAssembler barResourceAssembler(){
        return new BarResourceAssembler();
    }
}
