package Armas.Defensa;

import Armas.Arma;
import Armas.Ataque.ArmaAtaque;
import Personajes.WarhammerPersonaje;

public interface IArmamentoDefensa {

    public void defender(WarhammerPersonaje defendido, ArmaAtaque armaAtacante);

}
