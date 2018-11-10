package com.joseluis0218.proyecto_integrador.models;

import java.util.Date;

public class Captura {
    private String id_captura;
    private Date fecha_captura;
    private String nombre_captura;
    private String cantidad_rostros;
    private String id_usuario;

    public String getId_captura() {
        return id_captura;
    }

    public void setId_captura(String id_captura) {
        this.id_captura = id_captura;
    }

    public Date getFecha_captura() {
        return fecha_captura;
    }

    public void setFecha_captura(Date fecha_captura) {
        this.fecha_captura = fecha_captura;
    }

    public String getNombre_captura() {
        return nombre_captura;
    }

    public void setNombre_captura(String nombre_captura) {
        this.nombre_captura = nombre_captura;
    }

    public String getCantidad_rostros() {
        return cantidad_rostros;
    }

    public void setCantidad_rostros(String cantidad_rostros) {
        this.cantidad_rostros = cantidad_rostros;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return "Captura[id_captura=" + id_captura + ",fecha_captura=" + fecha_captura + ",nombre_captura=" + nombre_captura + ",cantidad_rostros=" + cantidad_rostros + ",id_usuario=" + id_usuario + "]";
    }
}
