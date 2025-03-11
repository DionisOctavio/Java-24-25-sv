package Armas.Ataque;

import Armas.Arma;
import Armas.Defensa.Armadura;
import Armas.Defensa.Escudo;
import Personajes.WarhammerPersonaje;

public class Martillo extends ArmaAtaque {

    private final int VIDA_CONSUMIDA = 0;

    public Martillo(String nombre) {
        super(nombre);
    }

    public int getVIDA_CONSUMIDA() {
        return VIDA_CONSUMIDA;
    }

    @Override
    public String toString() {
        return "Martillo{" +
                "VIDA_CONSUMIDA=" + VIDA_CONSUMIDA +
                '}';
    }

    @Override
    public void atacar(WarhammerPersonaje victima) {
        if (victima.armas.containsKey("Defensa")) {
            Arma armaDefensa = victima.armas.get("Defensa");
            if (armaDefensa instanceof Escudo) {
                System.out.println("|SE DEFIENDE| -- Al tener un Escudo se puede defender del Martillo → [" + victima + "]");
            }
        }

        if (victima.armas.containsKey("Defensa")) {
            Arma armaDefensa = victima.armas.get("Defensa");
            if (armaDefensa instanceof Armadura) {
                System.out.println("|SE DEFIENDE| -- Al tener una Armadura se puede defender del Martillo → [" + victima + "]");
            }
        }

    }

    @Override
    public void atacar(WarhammerPersonaje victima, boolean esAtaqueEmperador) {
        super.atacar(victima, esAtaqueEmperador);
    }
}
