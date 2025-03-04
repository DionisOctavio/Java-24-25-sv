package Armas.Ataque;

import Armas.Arma;

public class Hacha extends ArmaAtaque {

    private final int VIDA_CONSUMIDA = 0;

    public Hacha(String nombre) {
        super(nombre);
    }

    public int getVIDA_CONSUMIDA() {
        return VIDA_CONSUMIDA;
    }

    @Override
    public String toString() {
        return "Hacha{" +
                "VIDA_CONSUMIDA=" + VIDA_CONSUMIDA +
                '}';
    }

}
