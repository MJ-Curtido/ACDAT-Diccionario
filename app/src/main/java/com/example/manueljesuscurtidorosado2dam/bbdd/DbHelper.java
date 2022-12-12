package com.example.manueljesuscurtidorosado2dam.bbdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.Nullable;

import com.example.manueljesuscurtidorosado2dam.clases.Cadena;
import com.example.manueljesuscurtidorosado2dam.enums.TipoCadena;

import java.time.LocalDate;
import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {
    private static final int VERSIONBBDD = 1;
    private static final String NOMBREBBDD = "diccionario.db";


    public DbHelper(@Nullable Context context) {
        super(context, NOMBREBBDD, null, VERSIONBBDD);
    }

    @Override
    public void onCreate(SQLiteDatabase bbdd) {
        bbdd.execSQL(
            "CREATE TABLE \"cadena\" (\n" +
                "\t\"id\"\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t\"cadenaEspanyol\"\tTEXT NOT NULL,\n" +
                "\t\"cadenaIngles\"\tTEXT NOT NULL,\n" +
                "\t\"tipoCadena\"\tINTEGER NOT NULL,\n" +
                "\t\"fechaIntro\"\tTEXT NOT NULL,\n" +
                "\t\"fechaUlt\"\tTEXT NOT NULL,\n" +
                "\t\"numAciertos\"\tINTEGER NOT NULL\n" +
            ");"
        );

        ContentValues values = new ContentValues();
        values.put("cadenaEspanyol", "patata");
        values.put("cadenaIngles", "potatoe");
        values.put("tipoCadena", 0);
        values.put("fechaIntro", "2002-02-16");
        values.put("fechaUlt", "2022-12-13");
        values.put("numAciertos", 17);
        bbdd.insert("cadena", null, values);

        values = new ContentValues();
        values.put("cadenaEspanyol", "sandía");
        values.put("cadenaIngles", "watermelon");
        values.put("tipoCadena", 0);
        values.put("fechaIntro", "2020-10-07");
        values.put("fechaUlt", "2022-12-30");
        values.put("numAciertos", 0);
        bbdd.insert("cadena", null, values);

        values = new ContentValues();
        values.put("cadenaEspanyol", "feliz cumpleaños");
        values.put("cadenaIngles", "happy birthday");
        values.put("tipoCadena", 1);
        values.put("fechaIntro", "2021-05-10");
        values.put("fechaUlt", "2022-12-30");
        values.put("numAciertos", 7);
        bbdd.insert("cadena", null, values);

        values = new ContentValues();
        values.put("cadenaEspanyol", "buenas tardes amigo");
        values.put("cadenaIngles", "good afternoon my friend");
        values.put("tipoCadena", 1);
        values.put("fechaIntro", "2022-12-12");
        values.put("fechaUlt", "2022-12-12");
        values.put("numAciertos", 0);
        bbdd.insert("cadena", null, values);

        System.out.println("Base de datos creada correctamente.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long insertarCadena(Cadena cadena){
        long id = 0;

        try {
            SQLiteDatabase bbdd = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("cadenaEspanyol", cadena.getCadenaEspanyol());
            values.put("cadenaIngles", cadena.getCadenaIngles());
            values.put("tipoCadena", cadena.getTipoCadena().ordinal());
            values.put("fechaIntro", cadena.getFechaIntro().toString());
            values.put("fechaUlt", cadena.getFechaUlt().toString());
            values.put("numAciertos", cadena.getNumAciertos());

            id = bbdd.insert("cadena", null, values);

            System.out.println("Se ha introducido correctamente.");
        } catch (Exception ex){
            System.err.println("Algo falló al insertar.");
            System.err.println(ex.getMessage());
        }

        return id;
    }

    public ArrayList<Cadena> obtenerCadenas() {
        SQLiteDatabase bbdd = this.getWritableDatabase();

        ArrayList<Cadena> listaCadenas = new ArrayList<Cadena>();
        Cadena cadena = null;
        Cursor cursorCadena = null;

        cursorCadena = bbdd.rawQuery("SELECT * FROM cadena;", null);

        if (cursorCadena.moveToFirst()) {
            do {
                cadena = new Cadena();

                cadena.setId(cursorCadena.getInt(0));
                cadena.setCadenaEspanyol(cursorCadena.getString(1));
                cadena.setCadenaIngles(cursorCadena.getString(2));
                cadena.setTipoCadena(TipoCadena.values()[cursorCadena.getInt(3)]);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    cadena.setFechaIntro(LocalDate.parse(cursorCadena.getString(4)));
                    cadena.setFechaUlt(LocalDate.parse(cursorCadena.getString(5)));
                }
                cadena.setNumAciertos(cursorCadena.getInt(6));

                listaCadenas.add(cadena);
            } while(cursorCadena.moveToNext());
        }
        cursorCadena.close();

        return listaCadenas;
    }
}
