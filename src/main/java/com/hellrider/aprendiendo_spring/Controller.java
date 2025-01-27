package com.hellrider.aprendiendo_spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/app")
public class Controller {

    @ResponseBody
    @GetMapping("/saludo")
    public String saludo() {
        return "Hello World";
    }

    @ResponseBody
    @GetMapping("/user")
    public List<User> user() {
        return Arrays.asList(
                new User("hellrider", "klfhadlkfj"),
                new User("hellrider1990", "lkajfhaslkdfh")
        );
    }
}
