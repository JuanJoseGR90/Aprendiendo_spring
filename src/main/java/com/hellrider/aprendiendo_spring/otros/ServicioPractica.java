package com.hellrider.aprendiendo_spring.otros;

import org.springframework.stereotype.Service;

@Service
public class ServicioPractica {

    public String saludo(String nombre) {
        return "hola, me llamo " + nombre;
    }
}
