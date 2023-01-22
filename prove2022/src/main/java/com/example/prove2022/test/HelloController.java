package com.example.prove2022.test;

import com.testdome.service.BookRepository;
import com.testdome.service.BookSearchService;
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

    private final BookRepository bookRepository;
    private final BookSearchService bookSearchService;


    @GetMapping("/hello")
    public String hello(Model model){

        testService.getHelloMessage();
        model.addAttribute("data", "hello!!");
        System.out.println("------- getBooks before");
        bookRepository.getBooks();

        System.out.println("------- getBook after");
        bookSearchService.bookExists("awef");

        return "hello";
    }
}