package Personajes;

import Armas.Ataque.ArmaAtaque;
import Armas.Defensa.ArmaDefensa;

import java.util.ArrayList;

public class Rompehielo extends Enano{

    private ArrayList<Enano> lstaEnanos;

    public Rompehielo(String nombre, int riqueza) {
        super(nombre, riqueza);
        lstaEnanos = new ArrayList<>();
    }

    public ArrayList<Enano> getLstaEnanos() {
        for (Enano enano : lstaEnanos) {
            System.out.println(enano);
        }
        return lstaEnanos;
    }

    public void addEnano(Enano en) {
        lstaEnanos.add(en);
        System.out.println("Enano " + en + " agregado");
    }

    public void sumarEnergia(){
        super.sumarEnergia();
    }

    public void addArmaAtaque(ArmaAtaque arma){
        super.addArmaAtaque(arma);
    }

    public void addArmaDefensa(ArmaDefensa arma){
        super.addArmaDefensa(arma);
    }

    public void atacar(PielVerde victima){
        if (victima instanceof PielVerde) {
            System.out.println(this.nombre + " ataca brutalmente a " + victima.nombre + " que no se puede defender.");
        } else {
            System.out.println(this.nombre + " ataca a " + victima.nombre);
        }
    }

    @Override
    public void atacar(WarhammerPersonaje victima) {

    }

    @Override
    public void defender(ArmaAtaque arma) {

    }

    @Override
    public String toString() {
        return "Rompehielo{}";
    }

}
