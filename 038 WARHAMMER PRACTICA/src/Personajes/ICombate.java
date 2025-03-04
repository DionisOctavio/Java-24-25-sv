package Personajes;

import Armas.Ataque.ArmaAtaque;

public interface ICombate {

    public abstract void atacar(WarhammerPersonaje victima);

    public abstract void defender(ArmaAtaque arma);

}
