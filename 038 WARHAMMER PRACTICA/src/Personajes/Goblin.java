package Personajes;

import Armas.Ataque.ArmaAtaque;
import Armas.Defensa.ArmaDefensa;

public class Goblin  extends PielVerde{

    public Goblin(String nombre, String puebloNacimiento) {
        super(nombre, puebloNacimiento);
    }

    public void sumarEnergia(){}

    public void addArmaAtaque(ArmaAtaque arma){}

    public void addArmaDefensa(ArmaDefensa arma){}

    @Override
    public void atacar(WarhammerPersonaje victima) {

    }

    @Override
    public void defender(ArmaAtaque arma) {

    }

    @Override
    public String toString() {
        return "Goblin{" +
                "puebloNacimiento='" + puebloNacimiento + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
