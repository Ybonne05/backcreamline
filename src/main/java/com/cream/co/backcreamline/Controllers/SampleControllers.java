package com.cream.co.backcreamline.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SampleControllers {
    
    //http://localhost:8080/hell0-world
    @GetMapping("/new-hello")
    public String helloWorld(){
        return "Hello World";
    }
}
