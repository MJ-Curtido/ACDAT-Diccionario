package com.example.manueljesuscurtidorosado2dam.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.example.manueljesuscurtidorosado2dam.R;
import com.example.manueljesuscurtidorosado2dam.bbdd.DbHelper;
import com.example.manueljesuscurtidorosado2dam.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        DbHelper bbdd = new DbHelper(MainActivity.this);
        SQLiteDatabase sqLite = bbdd.getWritableDatabase();

        if (sqLite!=null){
            System.out.println("Se creó la BBDD.");
        } else {
            System.out.println("Error al crear la BBDD.");
        }

        binding.btnIntentInsertar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnIntentInsertar) {
            Intent i = new Intent(MainActivity.this, ActInsertar.class);
            startActivity(i);
        }
    }
}