package com.example.manueljesuscurtidorosado2dam.recycleviews;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.manueljesuscurtidorosado2dam.R;
import com.example.manueljesuscurtidorosado2dam.bbdd.DbHelper;
import com.example.manueljesuscurtidorosado2dam.clases.Cadena;
import com.example.manueljesuscurtidorosado2dam.vista.ActInsertar;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorDatos extends RecyclerView.Adapter<AdaptadorDatos.ViewHolder> implements View.OnClickListener {
    private List<ItemLista> mDataSet;
    private Context context;
    private ArrayList<Cadena> listaCadenas;
    private DbHelper dbHelper;
    private View.OnClickListener listener;

    public AdaptadorDatos(Context context) {
        this.context = context;
        mDataSet = new ArrayList<ItemLista>();
        dbHelper = new DbHelper(context);
        this.listaCadenas = dbHelper.obtenerCadenas();
    }

    public void add(ItemLista i) {
        mDataSet.add(i);
        notifyItemInserted(mDataSet.indexOf(i));
    }

    @NonNull
    @Override
    public AdaptadorDatos.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorDatos.ViewHolder holder, int position) {
        int pos = position;

        ItemLista itemLista = mDataSet.get(pos);
        holder.espanyol.setText(itemLista.getTxtEspanyol());
        holder.ingles.setText(itemLista.getTxtIngles());
        holder.tipo.setText(itemLista.getTxtTipo());
        holder.fechaIntro.setText(itemLista.getTxtFechaIntro());
        holder.fechaUlt.setText(itemLista.getTxtFechaUlt());
        /*
        View.OnClickListener evento = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cadena cadena = listaCadenas.get(pos);
            }
        };

        holder.espanyol.setOnClickListener(evento);
        holder.ingles.setOnClickListener(evento);
        holder.tipo.setOnClickListener(evento);
        holder.fechaIntro.setOnClickListener(evento);
        holder.fechaUlt.setOnClickListener(evento);
        */
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    @Override
    public void onClick(View view) {
        if (this.listener != null) {
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView espanyol;
        protected TextView ingles;
        protected TextView tipo;
        protected TextView fechaIntro;
        protected TextView fechaUlt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.espanyol = (TextView) itemView.findViewById(R.id.lblEspanyol);
            this.ingles = (TextView) itemView.findViewById(R.id.lblIngles);
            this.tipo = (TextView) itemView.findViewById(R.id.lblTipo);
            this.fechaIntro = (TextView) itemView.findViewById(R.id.lblFechaIntro);
            this.fechaUlt = (TextView) itemView.findViewById(R.id.lblFechaUlt);
        }
    }
}