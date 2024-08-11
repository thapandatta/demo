package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.Random;


@Component
public class getRandom {


    int min=10;

    int max=99;

    Random random= new Random();
    public long getrandom()
    {
        return random.nextInt(max-min+1)+min;
    }

}