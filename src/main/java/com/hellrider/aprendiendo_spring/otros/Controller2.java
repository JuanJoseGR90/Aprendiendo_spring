package com.hellrider.aprendiendo_spring.otros;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller2 {

    private final List<User2> users = new ArrayList<>();

    @PostMapping("/crear2")
    public ResponseEntity<User2> crear2(@RequestBody User2 user2) {
        user2.setId(users.size()+1);
        users.add(user2);
        return new ResponseEntity<>(user2, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User2>> getUsers() {
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
