package com.example.Batalla2;

import java.util.ArrayList;
import java.util.List;


public class Mago extends Criatura implements Magico {
    private final List<String> hechizos;

    public Mago(String nombre, int salud, int fuerza) {
        super(nombre, salud, fuerza);
        this.hechizos = new ArrayList<>();
    }

    @Override
    public void atacar(Criatura objetivo) {
        int danio = fuerza;
        System.out.println(nombre + " ataca a " + objetivo.getNombre()
                + " con magia y causa " + danio + " de daño base.");
        lanzarHechizo();

        if (arma != null) {
            arma.atacarConArma(objetivo);
            danio += arma.getDanioAdicional();
        }

        objetivo.defender(danio);
    }

    @Override
    public void defender(int danio) {
        salud -= danio;
        if (salud < 0) {
            salud = 0;
        }
        System.out.println(nombre + " recibió " + danio + " de daño. Salud restante: " + salud);
    }

    @Override
    public void lanzarHechizo() {
        if (hechizos.isEmpty()) {
            System.out.println(nombre + " lanza un hechizo básico.");
        } else {
            System.out.println(nombre + " lanza el hechizo: " + hechizos.get(0));
        }
    }

    @Override
    public void aprenderHechizo(String hechizo) {
        hechizos.add(hechizo);
        System.out.println(nombre + " aprendió el hechizo: " + hechizo);
    }

    public List<String> getHechizos() {
        return hechizos;
    }
}
