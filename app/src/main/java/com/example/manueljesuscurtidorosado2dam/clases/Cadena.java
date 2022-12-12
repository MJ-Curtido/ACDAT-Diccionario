package com.example.manueljesuscurtidorosado2dam.clases;

import android.os.Build;

import com.example.manueljesuscurtidorosado2dam.enums.TipoCadena;

import java.time.LocalDate;
import java.util.Objects;

public class Cadena {
    private Integer id;
    private String cadenaEspanyol, cadenaIngles;
    private TipoCadena tipoCadena;
    private LocalDate fechaIntro;
    private LocalDate fechaUlt;
    private Integer numAciertos;

    public Cadena(Integer id, String cadenaEspanyol, String cadenaIngles, TipoCadena tipoCadena, Integer numAciertos) {
        this.id = id;
        this.cadenaEspanyol = cadenaEspanyol;
        this.cadenaIngles = cadenaIngles;
        this.tipoCadena = tipoCadena;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.fechaIntro = LocalDate.now();
            this.fechaUlt = LocalDate.now();
        }
        this.numAciertos = numAciertos;
    }

    public Cadena(String cadenaEspanyol, String cadenaIngles, TipoCadena tipoCadena) {
        this.cadenaEspanyol = cadenaEspanyol;
        this.cadenaIngles = cadenaIngles;
        this.tipoCadena = tipoCadena;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.fechaIntro = LocalDate.now();
            this.fechaUlt = LocalDate.now();
        }
        this.numAciertos = 0;
    }

    public Cadena() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCadenaEspanyol() {
        return cadenaEspanyol;
    }

    public void setCadenaEspanyol(String cadenaEspanyol) {
        this.cadenaEspanyol = cadenaEspanyol;
    }

    public String getCadenaIngles() {
        return cadenaIngles;
    }

    public void setCadenaIngles(String cadenaIngles) {
        this.cadenaIngles = cadenaIngles;
    }

    public TipoCadena getTipoCadena() {
        return tipoCadena;
    }

    public void setTipoCadena(TipoCadena tipoCadena) {
        this.tipoCadena = tipoCadena;
    }

    public LocalDate getFechaIntro() {
        return fechaIntro;
    }

    public void setFechaIntro(LocalDate fechaIntro) {
        this.fechaIntro = fechaIntro;
    }

    public LocalDate getFechaUlt() {
        return fechaUlt;
    }

    public void setFechaUlt(LocalDate fechaUlt) {
        this.fechaUlt = fechaUlt;
    }

    public Integer getNumAciertos() {
        return numAciertos;
    }

    public void setNumAciertos(Integer numAciertos) {
        this.numAciertos = numAciertos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cadena that = (Cadena) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}