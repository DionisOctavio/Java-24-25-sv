package Armas;

import Pokemons.Pokemon;

public abstract class ArmaFuego implements Arma {

    private String nombre;

    public ArmaFuego(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public abstract void atacar(Pokemon enemigo);

    @Override
    public String getNombre(){
        return nombre;
    }
}
