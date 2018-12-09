package com.joseluis0218.proyecto_integrador.interfaces;

import com.joseluis0218.proyecto_integrador.models.Datos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    String API_BASE_URL = "http://192.168.1.136:8080";

    @GET("/api/datos/{id_captura}")
    Call<List<Datos>> getDatos(@Path("id_captura") Integer id_captura);
}
