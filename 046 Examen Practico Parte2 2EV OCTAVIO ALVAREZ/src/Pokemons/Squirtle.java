package Pokemons;

import Armas.Arma;

public class Squirtle extends PokemonAgua {

    public Squirtle(String nombre, int nivel, int energia) {
        super(nombre, nivel, energia);
    }

    @Override
    public void atacar(Pokemon enemigo) {
        System.out.println("Ataque de Agua impacta a " + enemigo.getNombre() + "!");
        enemigo.defender(30);
    }

    @Override
    public void defender(int dano) {
        energia = energia - dano;
        System.out.println("ENERGIA ACTUAL: " + energia);
    }

    @Override
    public void equiparArma(Arma armaEquipar) {

    }

    @Override
    public void usarArma(Pokemon enemigo) {

    }

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
