package com.hellrider.aprendiendo_spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class HolaController {

    @GetMapping("/saludo")
    public String saludo() {
        return "Hola Mundo";
    }

    @GetMapping("/user")
    public List<User> getUser() {
        return Arrays.asList(new User(
                "Juan José", 18),
                new User("Juan José", 24));
    }
}
