package com.example.util;

import org.springframework.stereotype.Component;

@Component
public class CricketGround implements Ground{

    @Override
    public int getSize() {
        return 100;
    }
    
}
