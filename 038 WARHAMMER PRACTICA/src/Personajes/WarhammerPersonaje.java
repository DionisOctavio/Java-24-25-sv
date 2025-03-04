package Personajes;

import Armas.Arma;
import Armas.Ataque.ArmaAtaque;

import java.util.HashMap;

public abstract class WarhammerPersonaje implements ICombate{

    protected String nombre;
    private int energia;

    protected HashMap<String, Arma> armas;

    private static int contPersonajes = 0;
    private final int ENERGIA_MAX = 200;

    public WarhammerPersonaje(String nombre) {
        this.nombre = nombre;
        armas = new HashMap<>();
        contPersonajes++;
    }

    public void sumarEnergia() {
        if (energia < ENERGIA_MAX) {
            energia += 10;
        }else {
            System.out.println("Has alcanzado tu energia maxima");
        }
    }

    public static void toNumPersonajes(){
        System.out.println("has creado " + contPersonajes + " personajes");
    }

    public String imprimirArmas(){
        String resultado = "";
        for ( String tipo:armas.keySet()){
            Arma arma = armas.get(tipo);
            resultado += tipo + ": " + arma + ": " + "\n";
        }
        return resultado;
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
