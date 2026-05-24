package com.example.demoForSpring.controller.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class FunRestController{

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    
    @GetMapping("/")
    public String sayHello() {
        return new String("Hello World"+" "+teamName+" "+coachName);
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "run a hard 5K";
    }
    
}