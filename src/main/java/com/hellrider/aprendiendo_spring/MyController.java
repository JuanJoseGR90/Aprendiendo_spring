package com.hellrider.aprendiendo_spring;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Controlador REST para manejar operaciones CRUD de usuarios.
 * <p>
 * Mapeado a la ruta base: /app
 *
 * <p><strong>Consideraciones importantes:</strong>
 * <ul>
 *   <li>Almacenamiento en memoria (no persistente)</li>
 *   <li>Los IDs se auto-generan secuencialmente</li>
 *   <li>Indexación basada en posición (ID 1 = índice 0)</li>
 * </ul>
 */
@Controller
@RequestMapping("/app")
public class MyController {

    private final List<User> USERS = new ArrayList<>();

    /**
     * Endpoint de prueba básico
     * @return Saludo en texto plano
     * @GET http://localhost:8080/app/saludo
     */
    @GetMapping("/saludo")
    @ResponseBody
    public String saludo() {
        return "Hello World";
    }

    /**
     * Obtiene lista predefinida de usuarios de prueba
     * @return Lista estática de 2 usuarios
     * @GET http://localhost:8080/app/user
     */
    @GetMapping("/user")
    @ResponseBody
    public List<User> user() {
        return Arrays.asList(
                new User("hellrider", "klfhadlkfj"),
                new User("hellrider1990", "lkajfhaslkdfh")
        );
    }

    /**
     * Obtiene todos los usuarios almacenados en memoria
     * @return Lista completa de usuarios
     * @GET http://localhost:8080/app/users
     */
    @GetMapping("/users")
    @ResponseBody
    public List<User> user2() {
        return USERS;
    }

    /**
     * Versión alternativa para obtener usuarios con ResponseEntity
     * @return Respuesta HTTP con lista de usuarios
     * @GET http://localhost:8080/app/users2
     */
    @GetMapping("/users2")
    public ResponseEntity<List<User>> verUsuarios() {
        return new ResponseEntity<>(USERS, HttpStatus.OK);
    }

    /**
     * Obtiene un usuario específico por su ID
     * @param id Número de identificación (comienza en 1)
     * @return Usuario correspondiente al ID
     * @GET http://localhost:8080/app/user/1
     */
    @GetMapping("/user/{id}")
    @ResponseBody
    public User obtenerUsuario(@PathVariable int id) {
        return USERS.get(id - 1);
    }

    /**
     * Crea un nuevo usuario recibiendo datos en formato JSON
     * @param user Objeto User en el cuerpo de la petición
     * @return Usuario creado con ID asignado
     * @POST http://localhost:8080/app/crear
     * @Example curl -X POST -H "Content-Type: application/json" -d '{"username":"test","password":"pass"}' http://localhost:8080/app/crear
     */
    @PostMapping("/crear")
    @ResponseBody
    public User createUser(@RequestBody User user) {
        user.setId(USERS.size() + 1);
        USERS.add(user);
        return user;
    }

    /**
     * Crea usuario usando parámetros de formulario
     * @param username Nombre de usuario (requerido)
     * @param password Contraseña (opcional)
     * @POST http://localhost:8080/app/crear2?username=test&password=123
     */
    @PostMapping("/crear2")
    @ResponseBody
    public void addUser(@RequestParam String username,
                        @RequestParam(required = false) String password) {
        User user = new User(username, password);
        USERS.add(user);
    }

    /**
     * Actualiza los datos de un usuario existente
     * @param id ID del usuario a modificar
     * @param actualizarUser Nuevos datos del usuario
     * @return Usuario modificado
     * @PUT http://localhost:8080/app/modificar/1
     */
    @PutMapping("/modificar/{id}")
    @ResponseBody
    public User actualizarUsuario(@PathVariable int id, @RequestBody User actualizarUser) {
        User actualizar = obtenerUsuario(id);
        actualizar.setUsername(actualizarUser.getUsername());
        actualizar.setPassword(actualizarUser.getPassword());
        return obtenerUsuario(id);
    }
}