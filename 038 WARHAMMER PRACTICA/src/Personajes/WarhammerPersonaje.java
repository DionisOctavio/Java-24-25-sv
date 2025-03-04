package Personajes;

import Armas.Arma;
import Armas.Ataque.ArmaAtaque;

import java.util.HashMap;

public abstract class WarhammerPersonaje implements ICombate{

    protected String nombre;
    private int energia;

    protected HashMap<String, Arma> armas;

    private static int contPersonajes;
    private final int ENERGIA_MAX = 200;

    public WarhammerPersonaje(String nombre) {
        this.nombre = nombre;
    }

    private void sumarEnergia() {

    }

    public static void toNumPersonajes(){
        System.out.println("");
        //return int;
    }

    public String imprimirArmas(){
        return "";
    }

    @Override
    public abstract void atacar(WarhammerPersonaje victima);

    @Override
    public abstract void defender(ArmaAtaque arma);

    @Override
    public String toString() {
        return "WarhammerPersonaje{" +
                "nombre='" + nombre + '\'' +
                ", energia=" + energia +
                ", ENERGIA_MAX=" + ENERGIA_MAX +
                '}';
    }


}
