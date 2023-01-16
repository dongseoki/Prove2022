package com.example.prove2022.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Controller
public class TestNonRestController {

    @PostMapping("/testuser")
    @ResponseBody
    public ResponseEntity saveTestUser(@Valid TestUser testUser, BindingResult bindingResult) throws InterruptedException, ExecutionException {
        if(bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
    /*
    save result
    * */
//        String name = null;
        String name = "";

// ...

        CompletableFuture<String> completableFuture
                =  CompletableFuture.supplyAsync(() -> {
            if (name == null) {
                throw new RuntimeException("Computation error!");
            }
            return "Hello, " + name;
        }).handle((s, t) -> s != null ? s : "Hello, Stranger!");
        String result = completableFuture.get();
        System.out.println("result = " + result);

//        assertEquals("Hello, Stranger!", completableFuture.get());

        CompletableFuture<String> completableFuture2
                = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<String> future = completableFuture2
                .thenApply(s -> s + " World");

//        assertEquals("Hello World", future.get());

        return ResponseEntity.ok(testUser);
    }
}
