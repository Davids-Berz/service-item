package com.ms.item;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean("clienteRestTemplate")
    RestTemplate restTemplatel() {
        return new RestTemplate();
    }
}
