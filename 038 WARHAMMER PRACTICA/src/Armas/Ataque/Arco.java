package Armas.Ataque;

import Armas.Arma;

public class Arco extends ArmaAtaque {

    private final int VIDA_CONSUMIDA = 0;

    public Arco(String nombre) {
        super(nombre);
    }

    public int getVIDA_CONSUMIDA() {
        return VIDA_CONSUMIDA;
    }

    @Override
    public String toString() {
        return "Arco{" +
                "VIDA_CONSUMIDA=" + VIDA_CONSUMIDA +
                '}';
    }
}
