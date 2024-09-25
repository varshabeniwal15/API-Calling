package com.scaler.productservicejune2024.configuration;

import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@PersistenceContext(type = PersistenceContextType.EXTENDED)

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }
}
