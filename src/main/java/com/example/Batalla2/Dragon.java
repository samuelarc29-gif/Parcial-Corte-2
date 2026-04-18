package com.example.Batalla2;


public class Dragon extends Criatura implements Volador {
    private final String escamas;

    public Dragon(String nombre, int salud, int fuerza, String escamas) {
        super(nombre, salud, fuerza);
        this.escamas = escamas;
    }

    @Override
    public void atacar(Criatura objetivo) {
        int danio = fuerza * 2;
        System.out.println(nombre + " ataca con fuego a " + objetivo.getNombre()
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

    @Override
    public void volar() {
        System.out.println(nombre + " se eleva por los cielos.");
    }

    @Override
    public void aterrizar() {
        System.out.println(nombre + " aterriza con fuerza.");
    }

    public String getEscamas() {
        return escamas;
    }
}
