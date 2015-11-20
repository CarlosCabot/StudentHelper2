package com.example.carloscabot.studenthelper.clases;

/**
 * Created by ismael.gonzalez on 18/11/15.
 */
public class TemasClase {
    private int fotoTema;
    private String nombreTema;

    public TemasClase(int foto, String nombre) {
        this.nombreTema = nombre;
        this.fotoTema = foto;
    }

    public String getNombreTema() {
        return nombreTema;
    }

    public void setNombreTema(String nombre) {
        this.nombreTema = nombre;
    }

    public int getFotoTema() {
        return fotoTema;
    }

    public void setFotoTema(int foto) {
        this.fotoTema = foto;
    }
}