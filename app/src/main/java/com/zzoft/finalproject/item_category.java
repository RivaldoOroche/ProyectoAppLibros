package com.zzoft.finalproject;

public class item_category {
    String autor;
    String titulo;
    String resumen;
    String portada;

    public item_category() {
    }

    public item_category(String titulo, String portada) {
        this.titulo = titulo;
        this.portada = portada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }
}
