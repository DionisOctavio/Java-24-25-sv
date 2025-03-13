package Pokemons;

import Armas.Arma;

public abstract class PokemonAgua extends Pokemon {

    protected String tipo = "agua";

    public PokemonAgua(String nombre, int nivel, int energia) {
        super(nombre, nivel, energia);
    }

    @Override
    public abstract void atacar(Pokemon enemigo);

    @Override
    public abstract void defender(int dano);

    public abstract void equiparArma(Arma armaEquipar);

    public abstract void usarArma(Pokemon enemigo);

    @Override
    public String toString() {
        return "Pokemon{" +
                "nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", energia=" + energia +
                ", Tipo=" + tipo +
                '}';
    }

}
