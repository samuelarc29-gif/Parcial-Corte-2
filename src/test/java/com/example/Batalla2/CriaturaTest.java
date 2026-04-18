package com.example.Batalla2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CriaturaTest {

    @Test
    public void testEstaViva() {
        Guerrero guerrero = new Guerrero("Conan", 100, 20);
        assertTrue(guerrero.estaViva());
    }

    @Test
    public void testDefenderReduceSalud() {
        Guerrero guerrero = new Guerrero("Conan", 100, 20);
        guerrero.defender(30);
        assertEquals(70, guerrero.getSalud());
    }

    @Test
    public void testDragonAtacaMasFuerte() {
        Dragon dragon = new Dragon("Draco", 100, 20, "Negras");
        Guerrero guerrero = new Guerrero("Conan", 100, 15);

        dragon.atacar(guerrero);

        assertEquals(60, guerrero.getSalud());
    }

    @Test
    public void testEquiparArmaAumentaDanio() {
        Guerrero guerrero = new Guerrero("Conan", 100, 20);
        Mago mago = new Mago("Gandalf", 100, 15);
        Arma espada = new Arma("Espada", 10);

        guerrero.equiparArma(espada);
        guerrero.atacar(mago);

        assertEquals(70, mago.getSalud());
    }

    @Test
    public void testMagoAprendeHechizo() {
        Mago mago = new Mago("Merlin", 100, 20);
        mago.aprenderHechizo("Rayo");

        assertEquals(1, mago.getHechizos().size());
        assertEquals("Rayo", mago.getHechizos().get(0));
    }
}
