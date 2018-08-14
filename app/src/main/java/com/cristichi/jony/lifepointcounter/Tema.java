package com.cristichi.jony.lifepointcounter;

import android.support.annotation.StyleRes;

public class Tema {

    public static Tema temaDiurno;
    public static Tema temaNocturno;

    private String nombre;
    private int tema;

    public Tema(String nombre, @StyleRes int tema){
        this.nombre = nombre;
        this.tema = tema;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTema() {
        return tema;
    }

    @Override
    public String toString() {
        return nombre.toUpperCase();
    }
}
