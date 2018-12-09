package com.joseluis0218.proyecto_integrador.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.curioustechizen.ago.RelativeTimeTextView;
import com.joseluis0218.proyecto_integrador.R;
import com.joseluis0218.proyecto_integrador.models.Captura;
import com.joseluis0218.proyecto_integrador.models.Datos;

import java.util.ArrayList;
import java.util.List;

public class DatosAdapter extends RecyclerView.Adapter<DatosAdapter.ViewHolder> {
    private List<Datos> datos;
    public DatosAdapter(){
        this.datos = new ArrayList<>();
    }
    public void setDatos(List<Datos> datos){
        this.datos = datos;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView estado_rotro;
        public TextView cantidad_rostros;
        public ViewHolder(View itemView) {
            super(itemView);
            estado_rotro = (TextView) itemView.findViewById(R.id.estado_rostro);
            cantidad_rostros = (TextView)itemView.findViewById(R.id.cantidad_rostros);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_datos, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        Datos dato = this.datos.get(position);

/*        viewHolder.estado_rotro.setText(dato.getEstado_rostro());
        viewHolder.cantidad_rostros.setText(dato.getCantidad_rostros().toString());*/
    }

    @Override
    public int getItemCount() {
        return this.datos.size();
    }

}
