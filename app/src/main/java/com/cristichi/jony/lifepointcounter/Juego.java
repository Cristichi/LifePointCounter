package com.cristichi.jony.lifepointcounter;

public enum Juego{

    YUGIOH("Yu-Gi-Oh", 8000),
    MAGIC("Magic: the Gathering", 4000),
    FOW("Force of Will", 4000),
    ;

    private String nombre;
    private int vidaInicial;

    //Constructor privado, bitchis
    Juego(String nombre, int lpi){
        this.nombre= nombre;
        vidaInicial= lpi;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVidaInicial() {
        return vidaInicial;
    }
}
