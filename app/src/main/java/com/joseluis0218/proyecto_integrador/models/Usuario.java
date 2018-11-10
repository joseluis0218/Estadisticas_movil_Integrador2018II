package com.joseluis0218.proyecto_integrador.models;

public class Usuario {
    private Integer id_usuario;
    private String nombres;
    private String apellidos;
    private String usuario;
    private String contraseña;
    private String email;

    public Integer getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Usuario[id_usuario="+id_usuario+","
                + "nombres="+nombres+","
                + "apellidos="+apellidos+","
                + "usuario="+usuario+","
                + "contraseña="+contraseña+","
                + ",email="+email+"]";
    }
}
