package com.hellrider.aprendiendo_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AprendiendoSpringApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AprendiendoSpringApplication.class, args);

        User user = new User("Hellrider", "hellrider@hellrider.com");

        ServicioSaludo servicioSaludo = context.getBean(ServicioSaludo.class);
        servicioSaludo.saveUser(user);
    }

}
