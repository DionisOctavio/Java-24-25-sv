package Personajes;

import Armas.Ataque.ArmaAtaque;
import Armas.Defensa.ArmaDefensa;

public abstract class Enano extends WarhammerPersonaje {

    protected int riqueza;

    private int nivel;

    private static int contEnanos;

    public Enano(String nombre, int riqueza) {
        super(nombre);
        this.riqueza = riqueza;
        contEnanos++;
    }

    public static int getContEnanos() {
        return contEnanos;
    }

    public void addArmaAtaque(ArmaAtaque arma) {
        armas.put("Ataque", arma);
    }

    public void addArmaDefensa(ArmaDefensa arma){
        armas.put("Defensa", arma);
    }

    public String imprimirArmas() {
        return super.imprimirArmas();
    }


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
