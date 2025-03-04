package Personajes;

import Armas.Ataque.ArmaAtaque;
import Armas.Defensa.ArmaDefensa;

public class Rompehielo extends Enano{

    public Rompehielo(String nombre, int riqueza) {
        super(nombre, riqueza);
    }

    public void sumarEnergia(){}

    public void addArmaAtaque(ArmaAtaque arma){}

    public void addArmaDefensa(ArmaDefensa arma){}

    public void atacar(PielVerde victima){}

    @Override
    public void atacar(WarhammerPersonaje victima) {

    }

    @Override
    public void defender(ArmaAtaque arma) {

    }

    @Override
    public String toString() {
        return "Rompehielo{}";
    }

}
