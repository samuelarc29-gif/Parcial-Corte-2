package com.example.Batalla2;


public class Main {

    public static void simularBatalla(Criatura criatura1, Criatura criatura2) {
        int turno = 1;

        System.out.println("\n====================================");
        System.out.println("INICIO DE LA BATALLA");
        System.out.println("====================================");
        System.out.println(criatura1.getEstado());
        criatura1.mostrarVidaEnCubos();
        System.out.println(criatura2.getEstado());
        criatura2.mostrarVidaEnCubos();
        System.out.println("====================================\n");

        while (criatura1.estaViva() && criatura2.estaViva()) {
            System.out.println("---------- TURNO " + turno + " ----------");

            if (criatura1 instanceof Volador volador1) {
                volador1.volar();
            }
            criatura1.atacar(criatura2);
            criatura2.mostrarVidaEnCubos();

            if (!criatura2.estaViva()) {
                System.out.println("\n" + criatura2.getNombre() + " ha muerto.");
                System.out.println("Ganador: " + criatura1.getNombre());
                break;
            }

            if (criatura1 instanceof Volador volador1) {
                volador1.aterrizar();
            }

            if (criatura2 instanceof Volador volador2) {
                volador2.volar();
            }
            criatura2.atacar(criatura1);
            criatura1.mostrarVidaEnCubos();

            if (!criatura1.estaViva()) {
                System.out.println("\n" + criatura1.getNombre() + " ha muerto.");
                System.out.println("Ganador: " + criatura2.getNombre());
                break;
            }

            if (criatura2 instanceof Volador volador2) {
                volador2.aterrizar();
            }

            System.out.println("\nEstado al final del turno " + turno + ":");
            System.out.println(criatura1.getNombre() + " -> Salud: " + criatura1.getSalud());
            System.out.println(criatura2.getNombre() + " -> Salud: " + criatura2.getSalud());
            System.out.println();
            turno++;
        }

        System.out.println("====================================");
        System.out.println("FIN DE LA BATALLA");
        System.out.println("====================================\n");
    }

    public static void main(String[] args) {
        Dragon dragon = new Dragon("Smaug", 120, 25, "Escamas rojas");
        Guerrero guerrero = new Guerrero("Leonidas", 110, 18);
        Mago mago = new Mago("Merlin", 90, 20);

        Arma garra = new Arma("Garra de fuego", 12);
        Arma espada = new Arma("Espada legendaria", 10);
        Arma baston = new Arma("Bastón mágico", 8);

        dragon.equiparArma(garra);
        guerrero.equiparArma(espada);
        mago.equiparArma(baston);
        mago.aprenderHechizo("Bola de fuego");
        mago.aprenderHechizo("Rayo congelante");

        simularBatalla(dragon, guerrero);
        simularBatalla(mago, dragon);
        simularBatalla(mago, guerrero);
    }
}
