package Armas.Ataque;

import Armas.Arma;
import Armas.Defensa.ArmaDefensa;
import Armas.Defensa.Casco;
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

        if (!victima.armas.containsKey("Ataque") && !victima.armas.containsKey("Defensa")){
            Random rand = new Random();
            int ale = rand.nextInt(2);

            if (ale == 0) {
                System.out.println("La flecha ha acertado");
            } else {
                System.out.println("La flecha ha fallado");
            }
        }

        if (victima.armas.containsKey("Defensa")) {
            Arma armaDefensa = victima.armas.get("Defensa");
            if (armaDefensa instanceof Casco) {
                System.out.println("|SE DEFIENDE| -- La flecha impacta contra el casco y no le causara Daño → [" + victima + "]");
            }
        }

        Random rand = new Random();

        int ale = rand.nextInt(2);

        if (ale == 0) {
            System.out.println("La flecha ha acertado");
        } else {
            System.out.println("La flecha ha fallado");
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
