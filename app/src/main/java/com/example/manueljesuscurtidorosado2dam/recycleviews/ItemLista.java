package com.example.manueljesuscurtidorosado2dam.recycleviews;

public class ItemLista {
    private String txtEspanyol, txtIngles, txtTipo, txtFechaIntro, txtFechaUlt;

    public ItemLista(String txtEspanyol, String txtIngles, String txtTipo, String txtFechaIntro, String txtFechaUlt) {
        this.txtEspanyol = txtEspanyol;
        this.txtIngles = txtIngles;
        this.txtTipo = txtTipo;
        this.txtFechaIntro = txtFechaIntro;
        this.txtFechaUlt = txtFechaUlt;
    }

    public String getTxtEspanyol() {
        return txtEspanyol;
    }

    public void setTxtEspanyol(String txtEspanyol) {
        this.txtEspanyol = txtEspanyol;
    }

    public String getTxtIngles() {
        return txtIngles;
    }

    public void setTxtIngles(String txtIngles) {
        this.txtIngles = txtIngles;
    }

    public String getTxtTipo() {
        return txtTipo;
    }

    public void setTxtTipo(String txtTipo) {
        this.txtTipo = txtTipo;
    }

    public String getTxtFechaIntro() {
        return txtFechaIntro;
    }

    public void setTxtFechaIntro(String txtFechaIntro) {
        this.txtFechaIntro = txtFechaIntro;
    }

    public String getTxtFechaUlt() {
        return txtFechaUlt;
    }

    public void setTxtFechaUlt(String txtFechaUlt) {
        this.txtFechaUlt = txtFechaUlt;
    }
}