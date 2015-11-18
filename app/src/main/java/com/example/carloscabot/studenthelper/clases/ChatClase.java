package com.example.carloscabot.studenthelper.clases;

/**
 * Created by javier.suarez on 18/11/15.
 */

/*Creacion de la clase, en esta se indicaran todos los elementos que contendra cada Row de la RecyclerView*/
public class ChatClase {
    private int foto;
    private String nombreAsignatura;

    public ChatClase(int foto, String nombreAsignatura) {
        this.foto = foto;
        this.nombreAsignatura = nombreAsignatura;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }
}
