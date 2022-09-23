package com.modern.process.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/home")
    public String getHome()
    {
        return "parinaz";
    }

    @GetMapping("/")
    public String getHomePage()
    {
        return "Hellooo world!";
    }
}
