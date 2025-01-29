package com.hellrider.aprendiendo_spring.otros;

import com.hellrider.aprendiendo_spring.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app2")
public class MyController2 {

    private final List<User> USERS = new ArrayList<>();

    @PostMapping("/crear2")
    @ResponseBody
    public User createUser(User user) {
        user.setId(USERS.size() + 1);
        USERS.add(user);
        return user;
    }

    @GetMapping("/usuarios")
    @ResponseBody
    public List<User> verUsuarios() {
        return USERS;
    }
}
