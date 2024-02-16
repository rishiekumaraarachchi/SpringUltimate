package com.example.springultimate;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {
   // @GetMapping("/hello")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String hello() {
        return "Hello, World!";
    }

    @PostMapping("/post")
    public String post(@RequestBody String message) {
        return "Post request has been made!" + message;
    }



    @PostMapping("/post-order")
    public String post(@RequestBody Orders order) {
        return "Order has been placed!" + order.toString();
    }


    @GetMapping("/hello/{userName}")
    public String pathVariable(@PathVariable String userName) {
        return "Hello, " + userName + "!";
    }

    @GetMapping("/hello")
    public String requestParam(@RequestParam("user-name") String userName, @RequestParam("age") int age) {
           return "Hello, " + userName + "! You are " + age + " years old.";
    }
}
