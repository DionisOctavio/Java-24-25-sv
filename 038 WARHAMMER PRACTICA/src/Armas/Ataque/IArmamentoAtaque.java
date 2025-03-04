package Armas.Ataque;

import Personajes.WarhammerPersonaje;

public interface IArmamentoAtaque {

    public void atacar(WarhammerPersonaje victima);

    public void atacar(WarhammerPersonaje victima, boolean esAtaqueEmperador);

}
