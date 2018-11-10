package com.joseluis0218.proyecto_integrador.interfaces;

import com.joseluis0218.proyecto_integrador.models.Captura;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    String API_BASE_URL = "http://node10.codenvy.io:37425";

    @GET("/capturas")
    Call<List<Captura>> getCapturas();
}
