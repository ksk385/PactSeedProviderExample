package com.thoughtworks;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
public class MockConfiguration {

    @Bean
    public SeedController seedController() {
        return new SeedController(seedRepository());
    }

    @Bean
    public SeedRepository seedRepository() {
        return mock(SeedRepository.class);
    }

}
