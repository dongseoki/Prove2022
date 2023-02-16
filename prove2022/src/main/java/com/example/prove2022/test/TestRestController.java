package com.example.prove2022.test;

import com.example.prove2022.test.domain.TestProduct;
import com.example.prove2022.test.dtos.TestRequestDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping(value = "/param-test")
    public String getProduct3(){
        return "repl Nothing Success";
    }
    @GetMapping(value = "/param-test", params = {"repl=true"})
    public String getProduct(@RequestBody TestRequestDto testRequestDto){

        return "repl True Success" + testRequestDto;
    }

    @GetMapping(value = "/param-test", params = {"repl=false"})
    public String getProduct2(){
        return "repl False Success";
    }
}
