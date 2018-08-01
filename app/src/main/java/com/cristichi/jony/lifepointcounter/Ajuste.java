package com.cristichi.jony.lifepointcounter;

import android.util.Log;

import java.util.ArrayList;

public class Ajuste<E>{

    public static ArrayList<Ajuste<String>> ajustesString;
    public static ArrayList<Ajuste<Boolean>> ajustesBoolean;

    private String nombre;
    private E valor;

    public Ajuste(String nombre, E valor){
        this.nombre= nombre;
        this.valor= valor;
    }

    public String getNombre() {
        return nombre;
    }

    public E getValor() {
        return valor;
    }

    public void setValor(E valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return nombre+" ["+valor.toString()+"]";
    }

    public static String getAjusteString(String nombre){
        for (int i = 0; i < ajustesString.size(); i++) {
            Ajuste<String> a = ajustesString.get(i);
            if (a.nombre.equals(nombre)){
                return a.valor;
            }
            Log.d("HOLA", nombre+"!="+a.valor);
        }
        throw new IllegalArgumentException("\""+nombre+"\" is not a valid option key");
    }

    public static void setAjusteString(String nombre, String valor){
        for (int i = 0; i < ajustesString.size(); i++) {
            Ajuste<String> a = ajustesString.get(i);
            if (a.nombre.equals(nombre)){
                a.setValor(valor);
            }
            Log.d("HOLA", nombre+"!="+a.valor);
        }
        throw new IllegalArgumentException("\""+nombre+"\" is not a valid option key");
    }

    public static Boolean getAjusteBooleano(String nombre){
        for (int i = 0; i < ajustesBoolean.size(); i++) {
            Ajuste<Boolean> a = ajustesBoolean.get(i);
            if (a.nombre.equals(nombre)){
                return a.valor;
            }
            Log.d("HOLA", nombre+"!="+a.valor);
        }
        throw new IllegalArgumentException("\""+nombre+"\" is not a valid option key");
    }

    public static void setAjusteBooleano(String nombre, boolean valor){
        for (int i = 0; i < ajustesBoolean.size(); i++) {
            Ajuste<Boolean> a = ajustesBoolean.get(i);
            if (a.nombre.equals(nombre)){
                a.setValor(valor);
            }
            Log.d("HOLA", nombre+"!="+a.valor);
        }
        throw new IllegalArgumentException("\""+nombre+"\" is not a valid option key");
    }
}
