package com.example.carloscabot.studenthelper.clases;

/**
 * Created by ismael.gonzalez on 18/11/15.
 */
public class AsignaturasClase {
    private int fotoAsig;
    private String nombreAsig;

    public AsignaturasClase(int foto, String nombre) {
        this.nombreAsig = nombre;
        this.fotoAsig = foto;
    }

    public String getNombreAsig() {
        return nombreAsig;
    }

    public void setNombreAsig(String nombre) {
        this.nombreAsig = nombre;
    }

    public int getFotoAsig() {
        return fotoAsig;
    }

    public void setFotoAsig(int foto) {
        this.fotoAsig = foto;
    }
}