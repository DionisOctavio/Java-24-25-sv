import Armas.Ataque.Arco;
import Armas.Ataque.Rebanadora;
import Armas.Defensa.Armadura;
import Armas.Defensa.Escudo;
import Personajes.Goblin;
import Personajes.Martillador;
import Personajes.PielVerde;
import Personajes.WarhammerPersonaje;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Goblin gob2 = new Goblin("ezquerra", "junto a cloe");
        Goblin gob3 = new Goblin("yeray", "en su putisima casa");

        Martillador martin1 = new Martillador("Diego", 999999999);
        Martillador marenostrum = new Martillador("pepe", 1);

        gob2.addGoblin(gob2);
        gob2.addGoblin(gob3);

        marenostrum.addMartillador(martin1);
        marenostrum.addMartillador(marenostrum);

        Random rand = new Random();
        int ale = rand.nextInt(2);
        if (ale == 1){
            Rebanadora reb = new Rebanadora("Sofia");
        }else{
            Arco arco = new Arco("Maria jose del carmen");
        }

        if (ale == 1){
            Armadura papel = new Armadura("javi");
        }else {
            Escudo lata = new Escudo("Lata");
        }

        gob3.getListaGoblin();

        marenostrum.getListaMartillador();

        WarhammerPersonaje.toNumPersonajes();

    }
}