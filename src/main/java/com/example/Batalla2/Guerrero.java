package com.example.Batalla2;


public class Guerrero extends Criatura {

    public Guerrero(String nombre, int salud, int fuerza) {
        super(nombre, salud, fuerza);
    }

    @Override
    public void atacar(Criatura objetivo) {
        int danio = fuerza;
        System.out.println(nombre + " ataca con espada a " + objetivo.getNombre()
                + " y causa " + danio + " de daño base.");

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
}
