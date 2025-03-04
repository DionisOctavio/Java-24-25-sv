package Personajes;

import Armas.Ataque.ArmaAtaque;
import Armas.Defensa.ArmaDefensa;

public abstract class PielVerde extends WarhammerPersonaje{

    protected String puebloNacimiento;
    protected int nivel;
    private static int contPielesVerdes;

    public PielVerde(String nombre, String puebloNacimiento) {
        super(nombre);
        this.puebloNacimiento = puebloNacimiento;
        contPielesVerdes++;
    }



    public static int getContPielesVerdes() {
        return contPielesVerdes;
    }

    public void addArmaAtaque(ArmaAtaque arma) {
        armas.put("Ataque", arma);
    }

    public void addArmaDefensa(ArmaDefensa arma){
        armas.put("Defensa", arma);
    }

    public String imprimirArmas() {
        return super.imprimirArmas();
    }

    @Override
    public abstract void atacar(WarhammerPersonaje victima);

    @Override
    public abstract void defender(ArmaAtaque arma);

    @Override
    public String toString() {
        return "PielVerde{" +
                "puebloNacimiento='" + puebloNacimiento + '\'' +
                ", nivel=" + nivel +
                '}';
    }

}
