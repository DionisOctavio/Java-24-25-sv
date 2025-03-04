package Personajes;

import Armas.Ataque.ArmaAtaque;
import Armas.Defensa.ArmaDefensa;

import java.util.ArrayList;

public class Goblin  extends PielVerde{

    ArrayList<Goblin> listGoblin;

    public Goblin(String nombre, String puebloNacimiento) {
        super(nombre, puebloNacimiento);
        listGoblin = new ArrayList<Goblin>();
    }

    public ArrayList<Goblin> getListaGoblin(){
        return listGoblin;
    }

    public void addGoblin(Goblin goblin){
        listGoblin.add(goblin);
        System.out.println("Goblin " + goblin + " agregado");
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

    @Override
    public void atacar(WarhammerPersonaje victima) {

    }

    @Override
    public void defender(ArmaAtaque arma) {

    }

    @Override
    public String toString() {
        return "Este goblin ha nacido en " + puebloNacimiento + " No tubo una infancia facil pero logro salir adelante su nombre es Sr." + nombre;
    }
}
