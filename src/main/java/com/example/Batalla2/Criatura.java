package com.example.Batalla2;

public abstract class Criatura {
    protected String nombre;
    protected int salud;
    protected int fuerza;
    protected Arma arma;

    public Criatura(String nombre, int salud, int fuerza) {
        this.nombre = nombre;
        this.salud = salud;
        this.fuerza = fuerza;
    }

    public abstract void atacar(Criatura objetivo);

    public abstract void defender(int danio);

    public boolean estaViva() {
        return salud > 0;
    }

    public void equiparArma(Arma arma) {
        this.arma = arma;
        System.out.println(nombre + " equipó " + arma.getNombre());
    }

    public void desequiparArma() {
        if (arma != null) {
            System.out.println(nombre + " desequipó " + arma.getNombre());
            arma = null;
        } else {
            System.out.println(nombre + " no tiene arma equipada.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public int getFuerza() {
        return fuerza;
    }

    public Arma getArma() {
        return arma;
    }

    public String getEstado() {
        String nombreArma = (arma != null) ? arma.getNombre() : "Sin arma";
        return "Clase: " + getClass().getSimpleName()
                + " | Nombre: " + nombre
                + " | Salud: " + salud
                + " | Fuerza: " + fuerza
                + " | Arma: " + nombreArma;
    }

    public void mostrarVidaEnCubos() {
        int cubos = (int) Math.ceil(salud / 20.0);
        StringBuilder barra = new StringBuilder();
        for (int i = 0; i < cubos; i++) {
            barra.append("■ ");
        }
        System.out.println(nombre + " vida: " + barra.toString().trim() + " (" + salud + ")");
    }
}
