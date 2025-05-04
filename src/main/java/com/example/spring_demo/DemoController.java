package com.example.spring_demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class DemoController {


    @GetMapping("/hello/{name}")
    public HelloResponse helloParam(@PathVariable String name) {
        //return "Hello, world!";
        return new HelloResponse("Hello, world!" + name);
    }

    @GetMapping("/hello")
    public HelloResponse hello() {
        //return "Hello, world!";
        return new HelloResponse("Hello, world!");
    }

    @PostMapping("/hello-post")
    public HelloResponse helloPost(@RequestBody String name) {
        return new HelloResponse("hello, " + name);
    }

}
