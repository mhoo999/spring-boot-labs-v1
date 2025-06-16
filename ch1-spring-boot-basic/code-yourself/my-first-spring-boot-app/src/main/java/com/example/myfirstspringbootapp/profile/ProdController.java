package com.example.myfirstspringbootapp.profile;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdController {
    @GetMapping("/prod")
    public String prod() {
        return "운영환경";
    }
}
