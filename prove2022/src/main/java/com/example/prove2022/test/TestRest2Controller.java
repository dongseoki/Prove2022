package com.example.prove2022.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test-rest")
public class TestRest2Controller {

    @GetMapping("/testHello2")
    public String testHello2(){
        return "success";
    }
}
