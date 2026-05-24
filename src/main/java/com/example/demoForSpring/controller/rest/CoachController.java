package com.example.demoForSpring.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.util.Coach;
import com.example.util.Ground;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CoachController {
    private Coach coach;
    private Coach myCoach;
    private Ground ground;
 
    // @Autowired
    // private Ground ground; // this is called field injection, but this was used in legacy systems and it is not recommended now.
    // this is not recommended because , it makes the code harder to unit test

    @Autowired // this is not required if there is only one constructor
    //This is constructor injection
    public CoachController(@Qualifier("aquatic") Coach coach, @Qualifier("cricketCoach") Coach myCoach){ // this will fail if multiple classes starts to implement the coach interface with @Component annotation spring gets confused.Hence to resolve the ambiguity we use @Qualifiers(specify the bean id:cricketCoach which same name as class but first character in lower case)
        System.out.println("In Constructor : "+getClass().getSimpleName());
        this.coach = coach;
        this.myCoach = myCoach;
    }
    // The issue with  multiple @Component classes for same interface can be solved using @Qualifier 
    // but it can also be solved using the @Primary annotation on the class which we want to inject, 
    // but if we add more than one @Primary for same interface then again the error comes in. 
    // So the recommended option is to use @Qualifier, it has higher priority than @Primary.

    @Autowired // setter injection, this @ can be used in any function, the @Qualifier can also be used in this setter Injection as same as constructor Injection. 
    public void setGround(Ground ground){
        this.ground = ground;
    }



    public Coach getCoach(){
        return coach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout(){
        return coach.getWorkOut()+" with ground size :"+ground.getSize();
    }

    @GetMapping("/checkInstances")
    public String getMethodName() {
        return "Checking whether both the instances are same: "+ (coach == myCoach);
    }//Checking whether both the instances are same: true as default
    //
    
}
