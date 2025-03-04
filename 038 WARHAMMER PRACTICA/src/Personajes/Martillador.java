package Personajes;

import Armas.Arma;
import Armas.Ataque.ArmaAtaque;
import Armas.Defensa.ArmaDefensa;

import java.util.ArrayList;

public class Martillador extends Enano{

    ArrayList<Martillador> listMartillador;

    public Martillador(String nombre, int riqueza) {
        super(nombre, riqueza);
        listMartillador = new ArrayList<Martillador>();
    }

    public ArrayList<Martillador> getListaMartillador() {

        for (Martillador m : listMartillador) {
            System.out.println(m);
        }

        return listMartillador;
    }

    public void addMartillador(Martillador latino){
        listMartillador.add(latino);
        System.out.println("Martillador " + latino + " agregado");

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
        System.out.println("Has atacado a un negro llamado: " + victima);
        System.out.println("Se ha quedado en el suelo desangrandose y un par de gitanos lo apalean");
    }

    @Override
    public void atacar(WarhammerPersonaje victima) {

    }

    @Override
    public void defender(ArmaAtaque arma) {

    }

    @Override
    public String toString() {
        return "Este goblin ha obtenido todo esta riqueza " + riqueza + " La consiguio de forma honrada y limpia, su nombre es Sr." + nombre;

    }

}
