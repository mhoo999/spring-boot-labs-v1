package com.example.myfirstspringbootapp.component_scan;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloComponentController {

    private final HelloComponentBean componentBean;

    public HelloComponentController(HelloComponentBean componentBean) {
        this.componentBean = componentBean;
    }

    @GetMapping("/hello-component")
    public String hello() {
        return componentBean.sayHello();
    }

}
