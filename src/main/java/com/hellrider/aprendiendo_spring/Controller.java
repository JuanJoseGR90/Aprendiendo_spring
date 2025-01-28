package com.hellrider.aprendiendo_spring;

import com.hellrider.aprendiendo_spring.otros.User2;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/app")
public class Controller {

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
    public void addUser(@RequestParam String username, @RequestParam String password) {
        User user = new User(username, password);
        users.add(user);
    }
}
