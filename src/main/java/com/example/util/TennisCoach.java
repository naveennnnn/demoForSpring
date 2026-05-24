package com.example.util;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy // this annotation make the bean to load when it is called by other bean and not at the application startup.
public class TennisCoach implements Coach{

    public TennisCoach(){
        System.out.println("In Constructor : "+getClass().getSimpleName());
    }
    @Override
    public String getWorkOut() {
        return "Do tennins practice";
    }
    
}
