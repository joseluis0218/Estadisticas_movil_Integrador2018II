package com.joseluis0218.proyecto_integrador.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.joseluis0218.proyecto_integrador.R;
import com.joseluis0218.proyecto_integrador.adapters.CapturaAdapter;
import com.joseluis0218.proyecto_integrador.clases.ApiServiceGenerator;
import com.joseluis0218.proyecto_integrador.interfaces.ApiService;
import com.joseluis0218.proyecto_integrador.models.Captura;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView capturasList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        capturasList = findViewById(R.id.lista_capturas);
        capturasList.setLayoutManager(new LinearLayoutManager(this));

        capturasList.setAdapter(new CapturaAdapter());
        initialize();
    }

    private void initialize() {

        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        Call<List<Captura>> call = service.getCapturas();

        call.enqueue(new Callback<List<Captura>>() {
            @Override
            public void onResponse(Call<List<Captura>> call, Response<List<Captura>> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        List<Captura> capturas = response.body();
                        Log.d(TAG, "capturas: " + capturas);

                        CapturaAdapter adapter = (CapturaAdapter) capturasList.getAdapter();
                        adapter.setCapturas(capturas);
                        adapter.notifyDataSetChanged();

                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<List<Captura>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });
    }

}

