package com.example.prove2022.test;

import com.example.prove2022.test.domain.TestProduct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test-rest")
public class TestRestController {

    @GetMapping("/product/{id}")
    public TestProduct getProduct(@PathVariable String id){
        TestProduct testProduct = TestProduct.builder().id(Long.valueOf(id)).name("test").build();

        return testProduct;
    }
}
