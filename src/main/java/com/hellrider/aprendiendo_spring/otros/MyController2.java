package com.hellrider.aprendiendo_spring.otros;

import com.hellrider.aprendiendo_spring.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app2")
public class MyController2 {

    private final List<User> USERS = new ArrayList<>();

    @PostMapping("/crear2")
    @ResponseBody
    public User createUser(@RequestBody User user) {
        user.setId(USERS.size() + 1);
        USERS.add(user);
        return user;
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<User>> verUsuarios() {
        return new ResponseEntity<>(USERS, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public User obtenerUsuario(@PathVariable int id) {
        return USERS.get(id - 1);
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
