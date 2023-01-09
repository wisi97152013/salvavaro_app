package com.example.model;

public class Usuario {

    public Usuario(String name, String email, String pass){
        this.nombre=name;
        this.correo=email;
        this.password=pass;
    }
    private String nombre;
    private String correo;
    private String password;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
