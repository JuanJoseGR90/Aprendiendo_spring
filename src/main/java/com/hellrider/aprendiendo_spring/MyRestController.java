package com.hellrider.aprendiendo_spring;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador REST para gestión de usuarios con operaciones CRUD completas.
 * <p>
 * Mapeado a la ruta base: /api/usuarios
 *
 * <p><strong>Descripción:</strong>
 * <ul>
 *   <li>Implementa operaciones CRUD básicas para gestión de usuarios</li>
 *   <li>Incluye endpoints para operaciones específicas de actualización parcial (PATCH)</li>
 *   <li>Manejo básico de errores mediante excepciones para recursos no encontrados</li>
 * </ul>
 *
 * <p><strong>Características técnicas:</strong>
 * <ul>
 *   <li>Almacenamiento en memoria volátil (los datos se pierden al reiniciar la aplicación)</li>
 *   <li>Generación automática de IDs secuenciales basados en el tamaño de la lista</li>
 *   <li>Integración con ServicioSaludo para funcionalidad adicional</li>
 * </ul>
 *
 * <p><strong>Dependencias:</strong>
 * <ul>
 *   <li>{@link ServicioSaludo} - Servicio auxiliar para generar saludos personalizados</li>
 * </ul>
 */
@RestController
@RequestMapping("/rest")
public class MyRestController {

    private final ServicioSaludo servicioSaludo;
    private final List<User> users = new ArrayList<>();

    public MyRestController(ServicioSaludo servicioSaludo) {
        this.servicioSaludo = servicioSaludo;
    }

    /**
     * Genera un saludo personalizado
     * @param nombre Nombre del usuario a saludar
     * @return Mensaje de saludo personalizado
     *
     * @Example GET <a href="http://localhost:8080/saludo?nombre=Ana">http://localhost:8080/saludo?nombre=Hellrider</a>
     */
    @GetMapping("/saludo")
    public String saludo(@RequestParam String nombre) {
        return servicioSaludo.saludo(nombre);
    }

    /**
     * Genera un saludo personalizado
     * @return Mensaje de saludo personalizado
     *
     * @Example GET <a href="http://localhost:8080/saludo?nombre=Ana">http://localhost:8080/saludo2</a>
     */
    @GetMapping("/saludo2")
    public String saludo2() {
        return servicioSaludo.saludo("JJ");
    }

    /**
     * Obtiene todos los usuarios registrados
     * @return Lista completa de usuarios en formato JSON
     *
     * @Example GET <a href="http://localhost:8080/api/usuarios">http://localhost:8080/api/usuarios</a>
     */
    @GetMapping
    public List<User> getUsers() {
        return users;
    }

    /**
     * Busca un usuario específico por su ID
     * @param id Identificador numérico único del usuario
     * @return Usuario correspondiente al ID solicitado
     * @throws RuntimeException Si no se encuentra el usuario (HTTP 500)
     *
     * @Example GET <a href="http://localhost:8080/api/usuarios/1">http://localhost:8080/api/usuarios/1</a>
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
     * @param usuario Objeto User en formato JSON (requiere username y password)
     * @return Usuario creado con ID asignado automáticamente
     *
     * @Example
     * POST <a href="http://localhost:8080/api/usuarios">http://localhost:8080/api/usuarios</a>
     * Body: {"username":"nuevoUsuario", "password":"contraseñaSegura"}
     */
    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public User crearUsuario(@RequestBody User usuario) {
        usuario.setId(users.size() + 1);
        users.add(usuario);
        return usuario;
    }

    /**
     * Actualiza todos los campos de un usuario existente
     * @param id ID del usuario a actualizar
     * @param usuarioActualizado Objeto User completo con nuevos valores
     * @return Usuario actualizado
     *
     * @Example
     * PUT <a href="http://localhost:8080/api/usuarios/1">http://localhost:8080/api/usuarios/1</a>
     * Body: {"username":"nuevoNombre", "password":"nuevaContraseña"}
     */
    @PutMapping("/{id}")
    public User actualizarUsuario(@PathVariable int id, @RequestBody User usuarioActualizado) {
        User usuarioExistente = getUser(id);
        usuarioExistente.setUsername(usuarioActualizado.getUsername());
        usuarioExistente.setPassword(usuarioActualizado.getPassword());
        return usuarioExistente;
    }

    /**
     * Actualiza parcialmente el nombre de usuario
     * @param id ID del usuario a modificar
     * @param username Nuevo nombre de usuario
     * @return Usuario con el nombre actualizado
     *
     * @Example PATCH <a href="http://localhost:8080/api/usuarios/1?username=nuevoNombre">http://localhost:8080/api/usuarios/1?username=nuevoNombre</a>
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
     *
     * @Example DELETE <a href="http://localhost:8080/api/usuarios/1">http://localhost:8080/api/usuarios/1</a>
     */
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable int id) {
        users.removeIf(u -> u.getId() == id);
    }
}