package com.joseluis0218.proyecto_integrador.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.curioustechizen.ago.RelativeTimeTextView;
import com.joseluis0218.proyecto_integrador.R;
import com.joseluis0218.proyecto_integrador.interfaces.ApiService;
import com.joseluis0218.proyecto_integrador.models.Captura;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CapturaAdapter extends RecyclerView.Adapter<CapturaAdapter.ViewHolder> {
    private List<Captura> capturas;
    public CapturaAdapter(){
        this.capturas = new ArrayList<>();
    }
    public void setCapturas(List<Captura> capturas){
        this.capturas = capturas;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView id_captura;
        public RelativeTimeTextView fecha_captura;
        public TextView nombre_captura;
        public TextView id_usuario;
        public TextView cantidad_rostros;
        public ViewHolder(View itemView) {
            super(itemView);
            id_captura = (TextView) itemView.findViewById(R.id.id_captura);
            fecha_captura = (RelativeTimeTextView) itemView.findViewById(R.id.fecha_captura);
            nombre_captura = (TextView)itemView.findViewById(R.id.nombre_captura);
            cantidad_rostros = (TextView)itemView.findViewById(R.id.cantidad_rostros);
            id_usuario = (TextView)itemView.findViewById(R.id.id_usuario);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_capturas, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        Captura captura = this.capturas.get(position);

        viewHolder.id_captura.setText(captura.getId_captura());
        viewHolder.fecha_captura.setReferenceTime(captura.getFecha_captura().getTime());
        viewHolder.nombre_captura.setText(captura.getNombre_captura());
        viewHolder.cantidad_rostros.setText(captura.getCantidad_rostros());
        viewHolder.id_usuario.setText(captura.getId_usuario());

    }

    @Override
    public int getItemCount() {
        return this.capturas.size();
    }

}
