package Armas.Defensa;

import Armas.Arma;
import Armas.Ataque.ArmaAtaque;
import Personajes.WarhammerPersonaje;

public class ArmaDefensa extends Arma implements IArmamentoDefensa {

    public ArmaDefensa(String nombre) {
        super(nombre);
    }

    @Override
    public void defender(WarhammerPersonaje defendido, ArmaAtaque armaAtacante) {

    }

}
