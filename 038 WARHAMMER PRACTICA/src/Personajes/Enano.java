package Personajes;

import Armas.Ataque.ArmaAtaque;
import Armas.Defensa.ArmaDefensa;

public abstract class Enano extends WarhammerPersonaje {

    private int riqueza;

    private int nivel;

    private static int contEnanos;

    public Enano(String nombre, int riqueza) {
        super(nombre);
        this.riqueza = riqueza;
    }

    public static int getContEnanos() {}

    public void addArmaAtaque(ArmaAtaque arma) {}

    public void addArmaDefensa(ArmaDefensa arma){}

    public String imprimirArmas() {}


    @Override
    public abstract void atacar(WarhammerPersonaje victima);

    @Override
    public abstract void defender(ArmaAtaque arma);

    @Override
    public String toString() {
        return "Enano{" +
                "riqueza=" + riqueza +
                ", nivel=" + nivel +
                '}';
    }
}
