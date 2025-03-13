package Pokemons;

import Armas.Arma;
import Armas.ArmaFuego;

public class Charmander extends PokemonFuego {

    private ArmaFuego arma;

    public Charmander(String nombre, int nivel, int energia) {
        super(nombre, nivel, energia);
    }

    @Override
    public void atacar(Pokemon enemigo) {
        System.out.println("Ataque de Fuego impacta a " + enemigo.getNombre() + "!");
        enemigo.defender(25);
    }

    @Override
    public void defender(int dano) {
        energia = energia - dano;
        System.out.println("ENERGIA ACTUAL: " + energia);
    }

    @Override
    public void equiparArma(Arma armaEquipar) {

        if (armaEquipar instanceof ArmaFuego) {
            System.out.println(armaEquipar.getNombre() + " Equipada");
            this.arma = (ArmaFuego) armaEquipar;
        }else{
            System.out.println("SOLO PUEDE EQUIPAR ARMAS DE FUEGO");
        }

    }

    @Override
    public void usarArma(Pokemon enemigo) {
        if(arma!=null){

        }
        System.out.println("Usamos arma " + arma.getNombre());
        System.out.println("Atacamos a " + enemigo.getNombre());
        enemigo.defender(25);

    }

    public ArmaFuego getArma() {
        return arma;
    }

    public void setArma(ArmaFuego arma) {
        this.arma = arma;
    }

    @Override
    public String toString() {
        return "Charmander{" +
                "nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", energia=" + energia +
                ", Arma=" + arma +
                '}';
    }
}
