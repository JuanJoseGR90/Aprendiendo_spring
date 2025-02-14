package com.hellrider.aprendiendo_spring.otros;

import com.hellrider.aprendiendo_spring.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/newrest")
public class RestControllerPractica {

    private List<User> USERS = new ArrayList<>();   //  base de datos simulada
    private ServicioPractica servicioPractica;  //  bean o dependencia inyectada tipo ServicioPractica

//    Inicialización de la dependencia inyectada
    public RestControllerPractica(ServicioPractica servicioPractica) {
        this.servicioPractica = servicioPractica;
    }

//    End-point que devuelve la lista de usuarios completa
    @GetMapping("/usuarios")
    public List<User> usuarios() {
        return USERS;
    }

//    End-point que crea un usuario y setea su id sumando 1 al tamaño total de la lista, antes de añadirlo
    @PostMapping("/crear")
    public void addUser(@RequestBody User user) {
        user.setId(USERS.size() + 1L);
        USERS.add(user);
    }

//    End-point que devuelve un saludo utilizado la dependencia inyectada
    @GetMapping("/saludo")
    public String saludo(@RequestParam String nombre) {
        return servicioPractica.saludo(nombre);
    }

    @GetMapping("/saludo2")
    public String saludo2() {
        return servicioPractica.saludo("JJ");
    }
}
