package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
public class WebDemo {
    private String msg;
    public WebDemo(){
        msg = "Привет, ";
    }
    // http://localhost:8080/api/demo/hello
    @GetMapping("/hello")
    public String getName(String name){return msg + name +"!";}
}

