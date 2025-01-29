package com.hellrider.aprendiendo_spring;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/app")
public class MyController {

    private final List<User> USERS = new ArrayList<>();

    @GetMapping("/saludo")
    @ResponseBody
    public String saludo() {
        return "Hello World";
    }

    @GetMapping("/user")
    @ResponseBody
    public List<User> user() {
        return Arrays.asList(
                new User("hellrider", "klfhadlkfj"),
                new User("hellrider1990", "lkajfhaslkdfh")
        );
    }

    @GetMapping("/users")
    @ResponseBody
    public List<User> user2() {
        return USERS;
    }

    @GetMapping("/users2")
    public ResponseEntity<List<User>> verUsuarios() {
        return new ResponseEntity<>(USERS, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public User obtenerUsuario(@PathVariable int id) {
        return USERS.get(id - 1);
    }

    @PostMapping("/crear")
    @ResponseBody
    public User createUser(@RequestBody User user) {
        user.setId(USERS.size() + 1);
        USERS.add(user);
        return user;
    }

    @PostMapping("/crear2")
    @ResponseBody
    public void addUser(@RequestParam String username, @RequestParam(required = false) String password) {
        User user = new User(username, password);
        USERS.add(user);
    }

    @PutMapping("/modificar/{id}")
    @ResponseBody
    public User actualizarUsuario(@PathVariable int id, @RequestBody User actualizarUser) {
        User actualizar = obtenerUsuario(id);
        actualizar.setUsername(actualizarUser.getUsername());
        actualizar.setPassword(actualizarUser.getPassword());
        return obtenerUsuario(id);
    }
}
