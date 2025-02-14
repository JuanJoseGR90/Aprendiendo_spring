package com.hellrider.aprendiendo_spring;

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
public class User {

    private Long id;
    private String username;
    private String password;

    /**
     * Constructor para creación de nuevos usuarios
     * @param username Nombre de usuario (requerido)
     * @param password Contraseña (sin encriptar)
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
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
    public String getUsername() {
        return username;
    }

    /**
     * @return Contraseña en texto plano
     */
    public String getPassword() {
        return password;
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
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Cambia la contraseña del usuario
     * @param password Nueva contraseña en texto plano
     */
    public void setPassword(String password) {
        this.password = password;
    }
}