package com.example.Batalla2;


public class Arma {
    private final String nombre;
    private final int danioAdicional;

    public Arma(String nombre, int danioAdicional) {
        this.nombre = nombre;
        this.danioAdicional = danioAdicional;
    }

    public void atacarConArma(Criatura objetivo) {
        System.out.println("El arma " + nombre + " agrega " + danioAdicional
                + " de daño contra " + objetivo.getNombre());
    }

    public int getDanioAdicional() {
        return danioAdicional;
    }

    public String getNombre() {
        return nombre;
    }
}
