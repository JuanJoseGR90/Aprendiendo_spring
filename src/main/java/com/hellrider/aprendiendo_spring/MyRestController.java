package com.hellrider.aprendiendo_spring;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class MyRestController {

    //  Simulo base de datos en memoria.
    private List<User> users = new ArrayList<>();

    //  Obtener todos los usuarios.
    @GetMapping
    public List<User> getUsers() {
        return users;
    }

    //  Obtener un usuario por id.
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    // POST: Crear un usuario
    @PostMapping
    public User crearUsuario(@RequestBody User usuario) {
        usuario.setId(users.size() + 1);
        users.add(usuario);
        return usuario;
    }

    // PUT: Actualizar un usuario completo
    @PutMapping("/{id}")
    public User actualizarUsuario(@PathVariable int id, @RequestBody User usuarioActualizado) {
        User usuarioExistente = getUser(id);
        usuarioExistente.setUsername(usuarioActualizado.getUsername());
        usuarioExistente.setPassword(usuarioActualizado.getPassword());
        return usuarioExistente;
    }

    // PATCH: Actualizar solo el nombre de un usuario
    @PatchMapping("/{id}")
    public User actualizarNombre(@PathVariable int id, @RequestParam String username) {
        User usuario = getUser(id);
        usuario.setUsername(username);
        return usuario;
    }

    // DELETE: Eliminar un usuario
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable int id) {
        users.removeIf(u -> u.getId() == id);
    }
}
