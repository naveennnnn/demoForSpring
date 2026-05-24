package com.example.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class SwimCoach implements Coach{

    @Override
    public String getWorkOut() {
        return "Do Swimming practice for freeStyle and butterfly in the ";
    }
    
}
