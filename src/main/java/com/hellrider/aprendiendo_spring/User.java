package com.hellrider.aprendiendo_spring;

import jakarta.persistence.*;

/**
 * Modelo que representa un usuario en el sistema.
 * <p>
 * Contiene los campos básicos de identificación y credenciales.
 *
 * <p><strong>Atributos:</strong>
 * <ul>
 *   <li>id - Identificador único generado automáticamente</li>
 *   <li>username - Nombre de usuario único</li>
 *   <li>password - Contraseña en texto plano (no seguro para producción)</li>
 * </ul>
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    // Constructor vacío requerido por JPA.
    public User() {}

    /**
     * Constructor para creación de nuevos usuarios
     * @param name Nombre de usuario (requerido)
     * @param email Contraseña (sin encriptar)
     */
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * @return ID numérico auto-generado
     */
    public Long getId() {
        return id;
    }

    /**
     * @return Nombre de usuario registrado
     */
    public String getName() {
        return name;
    }

    /**
     * @return Contraseña en texto plano
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el ID (usado internamente por el controlador)
     * @param id Nuevo identificador numérico
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Actualiza el nombre de usuario
     * @param username Nuevo nombre de usuario
     */
    public void setName(String username) {
        this.name = username;
    }

    /**
     * Cambia la contraseña del usuario
     * @param password Nueva contraseña en texto plano
     */
    public void setEmail(String password) {
        this.email = password;
    }
}