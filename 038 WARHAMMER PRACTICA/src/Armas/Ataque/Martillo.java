package Armas.Ataque;

import Armas.Arma;

public class Martillo extends ArmaAtaque {

    private final int VIDA_CONSUMIDA = 0;

    public Martillo(String nombre) {
        super(nombre);
    }

    public int getVIDA_CONSUMIDA() {
        return VIDA_CONSUMIDA;
    }

    @Override
    public String toString() {
        return "Martillo{" +
                "VIDA_CONSUMIDA=" + VIDA_CONSUMIDA +
                '}';
    }

}
