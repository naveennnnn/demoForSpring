package com.example.demoForSpring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.util.Coach;
import com.example.util.SwimCoach;

@Configuration // this and @Bean is used to create a bean for a third party api or library since we cant modify thier code to add @Component for dependency Injection
public class SportsConfig {

    @Bean("aquatic") // this aquatic now works as the bean Id instead of swimCoach.
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
