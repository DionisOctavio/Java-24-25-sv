package Pokemons;

import Armas.Arma;
import Armas.ArmaFuego;

public class Charmeleon extends Charmander {

    private ArmaFuego arma;

    public Charmeleon(String nombre, int nivel, int energia) {
        super(nombre, nivel, energia);
    }

    @Override
    public void atacar(Pokemon enemigo) {
        super.atacar(enemigo);
    }

    @Override
    public void defender(int dano) {
        super.defender(dano);
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
