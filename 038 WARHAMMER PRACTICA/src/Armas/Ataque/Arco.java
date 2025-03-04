package Armas.Ataque;

import Armas.Arma;
import Armas.Defensa.ArmaDefensa;
import Personajes.WarhammerPersonaje;

import java.util.Random;

public class Arco extends ArmaAtaque {

    private final int VIDA_CONSUMIDA = 0;

    public Arco(String nombre) {
        super(nombre);
    }

    public int getVIDA_CONSUMIDA() {
        return VIDA_CONSUMIDA;
    }

    @Override
    public void atacar(WarhammerPersonaje victima) {
        super.atacar(victima);

        Random rand = new Random();

        int ale = rand.nextInt(2);

        if (ale == 1){
            System.out.println("¡Flecha acertada!");
        } else {
            System.out.println("¡Flecha fallada!");
        }

    }

    @Override
    public void atacar(WarhammerPersonaje victima, boolean esAtaqueEmperador) {

    }

    @Override
    public String toString() {
        return "Arco{" +
                "VIDA_CONSUMIDA=" + VIDA_CONSUMIDA +
                '}';
    }
}
