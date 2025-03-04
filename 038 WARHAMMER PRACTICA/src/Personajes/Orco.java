package Personajes;

import Armas.Ataque.ArmaAtaque;
import Armas.Defensa.ArmaDefensa;

import java.util.ArrayList;

public class Orco extends PielVerde {

    ArrayList<PielVerde> pielesVerdes;

    public Orco(String nombre, String puebloNacimiento) {
        super(nombre, puebloNacimiento);

        pielesVerdes = new ArrayList<>();
    }

    public ArrayList<PielVerde> getPielesVerdes() {

        for (PielVerde p : pielesVerdes) {
            System.out.println(p);
        }
        return pielesVerdes;

    }

    public void addPielverde(PielVerde p) {
        pielesVerdes.add(p);
        System.out.println("Pieles Verde " + p + " agregado");
    }

    public void addArmaAtaque(ArmaAtaque arma){}

    public void addArmaDefensa(ArmaDefensa arma){}

    public void sumarEnergia(){}

    @Override
    public void atacar(WarhammerPersonaje victima) {

    }

    @Override
    public void defender(ArmaAtaque arma) {

    }

    @Override
    public String toString() {
        return "Orco{" +
                "puebloNacimiento='" + puebloNacimiento + '\'' +
                ", nivel=" + nivel +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
