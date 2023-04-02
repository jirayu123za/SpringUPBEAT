package com.project.upbeat.Config;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class CorConfig{
    @Bean
    public WebMvcConfigurer CoreConfig(){
        return new WebMvcConfigurer(){
            @Override
            public void addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry reg){
                reg.addMapping("/**")
                        .allowedOriginPatterns("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD")
                        .allowCredentials(true);
            }
        };
    }
}
