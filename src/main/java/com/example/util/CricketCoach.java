package com.example.util;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component // Marks the class as a spring bean and makes it available for the dependency injection.
//Spring Boot used to mark a Java class as a Spring-managed bean(@Service, @Repository, @Controller all have this component inside them).
@Primary // this is used to fix the ambiguity issue where multiple @Component bean are created for same interface.
// If more than one class @Component of same interface has @Primary then springboot will throw error
// @Lazy
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // this is to change the scope this instance that will be created
// this will return "Checking whether both the instances are same: false" for the checkInstances API. Because new object bean will be created for each injection
public class CricketCoach implements Coach{

    public CricketCoach(){
        System.out.println("In Constructor : "+getClass().getSimpleName());
    }
    @Override
    public String getWorkOut() {
        return "Do 15 minutes Bowling Workout!!!";
    }

    @PostConstruct // this will start during the initialization of this bean
    public void doMyStartupStuff(){
        System.out.println("In PostConstruct : "+getClass().getSimpleName());
    }

    @PreDestroy // this will start during the destruction of this bean
    public void doMyCleanupStuff(){
        System.out.println("In PreDestroy : "+getClass().getSimpleName());
    }
    
}
