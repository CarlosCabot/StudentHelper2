package com.example.carloscabot.studenthelper.clases;

/**
 * Created by yincong.yu on 19/11/15.
 */
public class Avisos {

    private int foto;
    private String nombre;

    public Avisos(int foto, String nombre) {
        this.foto = foto;
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
