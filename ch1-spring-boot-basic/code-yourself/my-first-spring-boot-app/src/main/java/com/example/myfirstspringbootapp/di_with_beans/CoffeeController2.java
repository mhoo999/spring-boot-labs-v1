package com.example.myfirstspringbootapp.di_with_beans;

import com.example.myfirstspringbootapp.di_with_beans.cafe.Barista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeController2 {

    @Autowired
    Barista barista;

    @GetMapping("/coffee-bean")
    public String coffee() {
        return barista.makeCoffee();
    }
}
