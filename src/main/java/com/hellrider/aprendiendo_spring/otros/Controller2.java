package com.hellrider.aprendiendo_spring.otros;

import com.hellrider.aprendiendo_spring.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/prueba")
public class Controller2 {

    private final List<User> users = new ArrayList<>();

    @GetMapping("/saludo")
    @ResponseBody
    public String saludo() {
        return "saludo";
    }

    @GetMapping("/users")
    @ResponseBody
    public List<User> getUsers() {
        return users;
    }

    @GetMapping("/create")
    @ResponseBody
    public String createUser(@RequestBody User user) {
        users.add(user);
        return "Usuario guardado";
    }
}
