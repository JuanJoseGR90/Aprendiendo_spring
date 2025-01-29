package com.hellrider.aprendiendo_spring;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador REST completo para gestión de usuarios con operaciones CRUD.
 * <p>
 * Mapeado a la ruta base: /api/usuarios
 *
 * <p><strong>Características principales:</strong>
 * <ul>
 *   <li>Implementa todas las operaciones CRUD básicas</li>
 *   <li>Incluye métodos PATCH para actualizaciones parciales</li>
 *   <li>Manejo básico de errores para recursos no encontrados</li>
 * </ul>
 *
 * <p><strong>Consideraciones:</strong>
 * <ul>
 *   <li>Almacenamiento en memoria volátil (reinicia con la aplicación)</li>
 *   <li>Los IDs se generan secuencialmente basados en el tamaño de la lista</li>
 *   <li>No persistencia entre sesiones</li>
 * </ul>
 */
@RestController
@RequestMapping("/api/usuarios")
public class MyRestController {

    // Simulación de base de datos en memoria
    private List<User> users = new ArrayList<>();

    /**
     * Obtiene todos los usuarios registrados
     * @return Lista completa de usuarios
     * @GET http://localhost:8080/api/usuarios
     */
    @GetMapping
    public List<User> getUsers() {
        return users;
    }

    /**
     * Busca un usuario específico por su ID
     * @param id Identificador numérico del usuario
     * @return Usuario correspondiente al ID
     * @throws RuntimeException Si no se encuentra el usuario
     * @GET http://localhost:8080/api/usuarios/1
     */
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    /**
     * Crea un nuevo usuario
     * @param usuario Objeto User en formato JSON
     * @return Usuario creado con ID asignado
     * @POST http://localhost:8080/api/usuarios
     * @Example curl -X POST -H "Content-Type: application/json" -d '{"username":"nuevo","password":"123"}' http://localhost:8080/api/usuarios
     */
    @PostMapping
    public User crearUsuario(@RequestBody User usuario) {
        usuario.setId(users.size() + 1);
        users.add(usuario);
        return usuario;
    }

    /**
     * Actualiza todos los campos de un usuario
     * @param id ID del usuario a actualizar
     * @param usuarioActualizado Objeto User con nuevos valores
     * @return Usuario actualizado
     * @PUT http://localhost:8080/api/usuarios/1
     */
    @PutMapping("/{id}")
    public User actualizarUsuario(@PathVariable int id, @RequestBody User usuarioActualizado) {
        User usuarioExistente = getUser(id);
        usuarioExistente.setUsername(usuarioActualizado.getUsername());
        usuarioExistente.setPassword(usuarioActualizado.getPassword());
        return usuarioExistente;
    }

    /**
     * Actualiza solo el nombre de usuario
     * @param id ID del usuario a modificar
     * @param username Nuevo nombre de usuario
     * @return Usuario con nombre actualizado
     * @PATCH http://localhost:8080/api/usuarios/1?username=nuevo_nombre
     */
    @PatchMapping("/{id}")
    public User actualizarNombre(@PathVariable int id, @RequestParam String username) {
        User usuario = getUser(id);
        usuario.setUsername(username);
        return usuario;
    }

    /**
     * Elimina un usuario existente
     * @param id ID del usuario a eliminar
     * @DELETE http://localhost:8080/api/usuarios/1
     */
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable int id) {
        users.removeIf(u -> u.getId() == id);
    }
}