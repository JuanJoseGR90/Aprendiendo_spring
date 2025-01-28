package com.hellrider.aprendiendo_spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/app")
public class MyController {

    private final List<User> users = new ArrayList<>();

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

    @ResponseBody
    @GetMapping("/users")
    public List<User> user2() {
        return users;
    }

    @ResponseBody
    @PostMapping("/crear")
    public void addUser(@RequestParam String username, @RequestParam(required = false) String password) {
        User user = new User(username, password);
        users.add(user);
    }
}
