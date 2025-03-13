package Pokemons;

import Armas.Arma;

public abstract class Pokemon implements EstrategiaAtaque {
    protected String nombre;
    protected int nivel;
    protected int energia;
    private Arma arma;

    public Pokemon(String nombre, int nivel, int energia) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.energia = energia;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract void atacar(Pokemon enemigo);
    public abstract void defender(int dano);

    public abstract void equiparArma(Arma armaEquipar);

    public abstract void usarArma(Pokemon enemigo);

    @Override
    public String toString() {
        return "Pokemon{" +
                "nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", energia=" + energia +
                '}';
    }
}
