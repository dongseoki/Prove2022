package com.example.prove2022.test;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HelloController {
    private final TestService testService;


    @GetMapping("/hello")
    public String hello(Model model){

        testService.getHelloMessage();
        model.addAttribute("data", "hello!!");
        return "hello";
    }
}