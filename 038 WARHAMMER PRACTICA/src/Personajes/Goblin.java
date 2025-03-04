package Personajes;

import Armas.Ataque.ArmaAtaque;
import Armas.Defensa.ArmaDefensa;

import java.util.ArrayList;

public class Goblin  extends PielVerde{

    ArrayList<Goblin> listGoblin;

    public Goblin(String nombre, String puebloNacimiento, int nivel) {
        super(nombre, puebloNacimiento );
        super.nivel = nivel;
        listGoblin = new ArrayList<Goblin>();
    }

    public ArrayList<Goblin> getListaGoblin(){

        for ( Goblin g : listGoblin ){
            System.out.println(g);
        }
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
        return "Goblin{" +
                "nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", puebloNacimiento='" + puebloNacimiento + '\'' +
                '}';
    }
}
