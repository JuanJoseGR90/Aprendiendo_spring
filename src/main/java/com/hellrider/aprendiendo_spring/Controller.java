package com.hellrider.aprendiendo_spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/app")
public class Controller {

    @GetMapping("/saludo")
    public String saludo() {
        return "Hello World";
    }

    @GetMapping("/user")
    public List<User> user() {
        return Arrays.asList(
                new User("hellrider", "klfhadlkfj"),
                new User("hellrider1990", "lkajfhaslkdfh")
        );
    }
}
