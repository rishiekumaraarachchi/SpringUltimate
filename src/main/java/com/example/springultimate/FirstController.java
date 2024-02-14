package com.example.springultimate;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {
    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String hello() {
        return "Hello, World!";
    }

    @PostMapping("/post")
    public String post(@RequestBody String message) {
        return "Post request has been made!" + message;
    }
}
