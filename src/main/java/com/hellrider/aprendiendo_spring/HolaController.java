package com.hellrider.aprendiendo_spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {

    @GetMapping("/saludo")
    public String saludo() {
        return "Hola Mundo";
    }
}
