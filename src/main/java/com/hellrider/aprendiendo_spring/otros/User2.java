package com.hellrider.aprendiendo_spring.otros;

public class User2 {

    private String username;
    private String edad;
    private int id;

    public User2() {}

    public User2(String username, String edad) {
        this.username = username;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
}
