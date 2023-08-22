package com.example.pharmacyfindproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate(){ //spring에서 제공하는 rest템플릿이다
        return new RestTemplate();
    }

}
