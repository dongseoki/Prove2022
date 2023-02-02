package com.example.prove2022.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test-rest")
public class TestRest1Controller {

    @GetMapping("/testHello1")
    public String testHello1(){
        return "success";
    }
}
