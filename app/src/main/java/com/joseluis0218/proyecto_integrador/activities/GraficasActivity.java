package com.joseluis0218.proyecto_integrador.activities;

import android.os.DropBoxManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.joseluis0218.proyecto_integrador.R;
import com.joseluis0218.proyecto_integrador.adapters.CapturaAdapter;
import com.joseluis0218.proyecto_integrador.clases.ApiServiceGenerator;
import com.joseluis0218.proyecto_integrador.interfaces.ApiService;
import com.joseluis0218.proyecto_integrador.models.Captura;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GraficasActivity extends AppCompatActivity {

    private BarChart barChart;
    private static final String TAG = GraficasActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graficas);

        barChart = (BarChart) findViewById(R.id.chart);
        barChart.getDescription().setEnabled(false);
        setData(5);

    }

    private void setData(int count){
        ArrayList<BarEntry> vals = new ArrayList<>();

            float value = (float) (Math.random()*100);
            vals.add(new BarEntry(i,(int) value));
        }

        BarDataSet set = new BarDataSet(vals,"Estados");
        set.setColors(ColorTemplate.MATERIAL_COLORS);
        set.setDrawValues(true);

        BarData data = new BarData(set);

        barChart.setData(data);
        barChart.invalidate();
        barChart.animateY(500);
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

                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(GraficasActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<List<Captura>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(GraficasActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });
    }

}



