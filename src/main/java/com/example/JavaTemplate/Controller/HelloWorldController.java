package com.example.JavaTemplate.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class HelloWorldController {
    @GetMapping
    public String showHelloWorldOnPage(){

        return "Hello World";

    }

}
