package com.example.manueljesuscurtidorosado2dam.vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.manueljesuscurtidorosado2dam.R;
import com.example.manueljesuscurtidorosado2dam.bbdd.DbHelper;
import com.example.manueljesuscurtidorosado2dam.clases.Cadena;
import com.example.manueljesuscurtidorosado2dam.databinding.ActivityActInsertarBinding;
import com.example.manueljesuscurtidorosado2dam.enums.TipoCadena;
import com.example.manueljesuscurtidorosado2dam.recycleviews.AdaptadorDatos;
import com.example.manueljesuscurtidorosado2dam.recycleviews.ItemLista;

import java.util.ArrayList;

public class ActInsertar extends AppCompatActivity implements View.OnClickListener {
    private ActivityActInsertarBinding binding;
    private DbHelper dbHelper;
    private AdaptadorDatos adaptadorDatos;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<Cadena> listaCadenas;
    private Boolean modoEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityActInsertarBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnInsertarCadena.setOnClickListener(this);
        dbHelper = new DbHelper(ActInsertar.this);

        modoEditar = false;

        listaCadenas = dbHelper.obtenerCadenas();
        linearLayoutManager = new LinearLayoutManager(ActInsertar.this);
        binding.rvCadenas.setLayoutManager(linearLayoutManager);
        adaptadorDatos = new AdaptadorDatos(ActInsertar.this);
        binding.rvCadenas.setAdapter(adaptadorDatos);

        for (int i = 0; i < listaCadenas.size(); i++) {
            adaptadorDatos.add(new ItemLista(listaCadenas.get(i).getCadenaEspanyol(), listaCadenas.get(i).getCadenaIngles(), listaCadenas.get(i).getTipoCadena().toString(), listaCadenas.get(i).getFechaIntro().toString(), listaCadenas.get(i).getFechaUlt().toString()));
        }

        adaptadorDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listaCadenas.get(binding.rvCadenas.getChildAdapterPosition(view));
                binding.tbCadenaEspanyol.setText(listaCadenas.get(binding.rvCadenas.getChildAdapterPosition(view)).getCadenaEspanyol());
                binding.tbCadenaIngles.setText(listaCadenas.get(binding.rvCadenas.getChildAdapterPosition(view)).getCadenaIngles());
                binding.rbtnGrupo.check(listaCadenas.get(binding.rvCadenas.getChildAdapterPosition(view)).getTipoCadena().ordinal());

                modoEditar = true;
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnInsertarCadena) {
            int rbtnCheck;

            if (binding.rbtnPalabra.isChecked()) {
                rbtnCheck = 0;
            }
            else {
                rbtnCheck = 1;
            }

            if (!modoEditar) {
                long insertado = dbHelper.insertarCadena(new Cadena(binding.tbCadenaEspanyol.getText().toString(), binding.tbCadenaIngles.getText().toString(), TipoCadena.values()[rbtnCheck]));

                binding.tbCadenaEspanyol.setText("");
                binding.tbCadenaIngles.setText("");

                if (insertado != 0) {
                    Toast.makeText(this, "Insertado correctamente.", Toast.LENGTH_SHORT).show();
                }
            }
            else {

            }
        }
    }
}