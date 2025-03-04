package Armas.Defensa;

import Armas.Arma;

public class Casco extends ArmaDefensa {

    private final int VIDA_DEFENDIDA = 0;

    public Casco(String nombre) {
        super(nombre);
    }

    public int getVIDA_DEFENDIDA() {
        return VIDA_DEFENDIDA;
    }

    @Override
    public String toString() {
        return "Casco{" +
                "VIDA_DEFENDIDA=" + VIDA_DEFENDIDA +
                '}';
    }

}
