package com.mikheev.homework.services.impl;

import com.mikheev.homework.services.IOService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class TestConfig {

    @Bean
    @Primary
    IOService ioService(){
        return Mockito.mock(IOService.class);
    }
}
