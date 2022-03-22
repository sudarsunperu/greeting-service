package com.example.demo.greetings.restservice;

import com.example.demo.greetings.entity.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s! Have a Good Day!!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name,
                             @RequestParam(value = "capitalize", defaultValue = "false") boolean capitalize) {
        if(capitalize)
            name = name.toUpperCase();
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
