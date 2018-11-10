package com.joseluis0218.proyecto_integrador.models;

public class Rostro {

    private Integer id_rostro;
    private String genero_rostro;
    private String estado_rostro;
    private Integer id_captura;
    public Integer getId_rostro() {
        return id_rostro;
    }
    public void setId_rostro(Integer id_rostro) {
        this.id_rostro = id_rostro;
    }
    public String getGenero_rostro() {
        return genero_rostro;
    }
    public void setGenero_rostro(String genero_rostro) {
        this.genero_rostro = genero_rostro;
    }
    public String getEstado_rostro() {
        return estado_rostro;
    }
    public void setEstado_rostro(String estado_rostro) {
        this.estado_rostro = estado_rostro;
    }

    public Integer getId_captura() {
        return id_captura;
    }
    public void setId_captura_id(Integer id_captura) {
        this.id_captura = id_captura;
    }
    @Override
    public String toString() {
        return "Rostro[id_rostro="+id_rostro+",genero_rostro="+genero_rostro+",estado_rostro="+estado_rostro+",id_captura="+id_captura+"]";
    }
}
