package Personajes;

import Armas.Ataque.ArmaAtaque;
import Armas.Defensa.ArmaDefensa;

import java.util.ArrayList;

public class Orco extends PielVerde {

    public Orco(String nombre, String puebloNacimiento) {
        super(nombre, puebloNacimiento);
    }

    public void addArmaAtaque(ArmaAtaque arma){}

    public void addArmaDefensa(ArmaDefensa arma){}

    public void sumarEnergia(){}

    @Override
    public void atacar(WarhammerPersonaje victima) {

    }

    @Override
    public void defender(ArmaAtaque arma) {

    }



}
