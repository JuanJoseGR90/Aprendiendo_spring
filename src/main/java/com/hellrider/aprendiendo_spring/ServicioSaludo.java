package com.hellrider.aprendiendo_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio para generar mensajes de saludo personalizados
 *
 * <p><strong>Responsabilidad:</strong>
 * <ul>
 *   <li>Proveer mensajes de saludo con formato específico</li>
 *   <li>Personalizar los mensajes basados en el nombre recibido</li>
 * </ul>
 *
 * <p><strong>Uso típico:</strong>
 * <ul>
 *   <li>Integrado en controladores REST que requieren funcionalidad de saludo</li>
 *   <li>Generación de mensajes amigables para el usuario final</li>
 * </ul>
 */
@Service
public class ServicioSaludo {

    public ServicioSaludo() {

    }

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    /**
     * Genera un mensaje de saludo personalizado
     * @param nombre Nombre del usuario a saludar
     * @return Cadena con el mensaje formateado
     *
     * @Example Entrada: "Hellrider" → Salida: "Hola, debes ser Hellrider!. Soy tu servicio de saludo :)"
     */
    public String saludo(String nombre) {
        return "Hola, debes ser " + nombre + "!. Soy tu servicio de saludo :)";
    }
}