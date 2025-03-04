package Personajes;

import Armas.Ataque.ArmaAtaque;
import Armas.Defensa.ArmaDefensa;

import java.util.ArrayList;

public class Orco extends PielVerde {

    ArrayList<Goblin> listGoblin;


    public Orco(String nombre, String puebloNacimiento) {
        super(nombre, puebloNacimiento);
    }

    public ArrayList<Goblin> getListaGoblin(){}

    public void addArmaAtaque(ArmaAtaque arma){}

    public void addArmaDefensa(ArmaDefensa arma){}

    public void sumarEnergia(){}

    public void addGoblin(){}

    @Override
    public void atacar(WarhammerPersonaje victima) {

    }

    @Override
    public void defender(ArmaAtaque arma) {

    }



}
