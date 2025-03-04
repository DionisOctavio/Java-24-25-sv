package Armas.Ataque;

import Armas.Arma;
import Personajes.WarhammerPersonaje;

public class ArmaAtaque extends Arma implements IArmamentoAtaque {

    public ArmaAtaque(String nombre) {
        super(nombre);
    }

    @Override
    public void atacar(WarhammerPersonaje victima) {

        System.out.println("Estas atacando a " + victima);

    }

    @Override
    public void atacar(WarhammerPersonaje victima, boolean esAtaqueEmperador) {

    }

}
