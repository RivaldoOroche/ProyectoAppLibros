package com.zzoft.finalproject;

import java.io.Serializable;

public class item_category implements Serializable {
    String id;
    String autor;
    String titulo;
    String resumen;
    String portada;

    public item_category() {
    }

    public item_category(String id, String titulo, String portada) {
        this.id = id;
        this.titulo = titulo;
        this.portada = portada;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
