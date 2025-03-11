import Armas.Ataque.Arco;
import Armas.Ataque.Hacha;
import Armas.Ataque.Martillo;
import Armas.Ataque.Rebanadora;
import Armas.Defensa.Armadura;
import Armas.Defensa.Casco;
import Armas.Defensa.Escudo;
import Personajes.*;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // || --- |Nota para obtener de un 0 a un 3| --- ||

        Goblin gob2 = new Goblin("ezquerra", "junto a cloe", 20);
        Goblin gob3 = new Goblin("yeray", "en su putisima casa", 20);

        Martillador martin1 = new Martillador("Diego", 1000);
        Martillador marenostrum = new Martillador("pepe", 1000);

        gob2.addGoblin(gob2);
        gob2.addGoblin(gob3);

        marenostrum.addMartillador(martin1);
        marenostrum.addMartillador(marenostrum);

        Random rand = new Random();

        int aleGob = rand.nextInt(2);
        if (aleGob == 1){
            Rebanadora reb = new Rebanadora("Sofia");
            gob2.addArmaAtaque(reb);
            gob3.addArmaAtaque(reb);
        }else{
            Arco arco = new Arco("Maria jose del carmen");
            gob2.addArmaAtaque(arco);
            gob3.addArmaAtaque(arco);
        }

        if (aleGob == 1){
            Armadura papel = new Armadura("javi");
            gob2.addArmaDefensa(papel);
            gob3.addArmaDefensa(papel);
        }else {
            Escudo lata = new Escudo("Lata");
            gob2.addArmaDefensa(lata);
            gob3.addArmaDefensa(lata);
        }

        int aleMar = rand.nextInt(2);
        if (aleMar == 1){
            Hacha pez = new Hacha("Pepe");
            marenostrum.addArmaAtaque(pez);
            martin1.addArmaAtaque(pez);
        }else{
            Martillo pluma = new Martillo("Pluma");
            marenostrum.addArmaAtaque(pluma);
            martin1.addArmaAtaque(pluma);
        }

        if (aleMar == 1){
            Casco gorra = new Casco("Gorra");
            marenostrum.addArmaDefensa(gorra);
            martin1.addArmaDefensa(gorra);
        }else {
            Armadura lata = new Armadura("Lata");
            marenostrum.addArmaDefensa(lata);
            martin1.addArmaDefensa(lata);
        }

        gob3.getListaGoblin();

        marenostrum.getListaMartillador();

        WarhammerPersonaje.toNumPersonajes();






        // || --- |Nota para obtener de un 3 a un 5| --- ||

        Goblin gob4 = new Goblin("jose luis", "mark", 40);
        Goblin gob5 = new Goblin("selva", "Zaragoza, en el Gancho", 40);

        Martillador marenostrum2 = new Martillador("Akira", 2000);
        Martillador marenostrum3 = new Martillador("Goku", 2000);

        gob4.addGoblin(gob5);
        gob4.addGoblin(gob4);

        marenostrum2.addMartillador(marenostrum2);
        marenostrum3.addMartillador(marenostrum3);


        int aleGob2 = rand.nextInt(2);
        if (aleGob2 == 1){
            Rebanadora reb = new Rebanadora("Sofia");
            gob4.addArmaAtaque(reb);
            gob5.addArmaAtaque(reb);
        }else{
            Arco arco = new Arco("Maria jose del carmen");
            gob4.addArmaAtaque(arco);
            gob5.addArmaAtaque(arco);
        }

        if (aleGob2 == 1){
            Armadura papel = new Armadura("javi");
            gob4.addArmaDefensa(papel);
            gob5.addArmaDefensa(papel);
        }else {
            Escudo lata = new Escudo("Lata");
            gob4.addArmaDefensa(lata);
            gob5.addArmaDefensa(lata);
        }

        int aleMar2 = rand.nextInt(2);
        if (aleMar2 == 1){
            Hacha pez = new Hacha("Pepe");
            marenostrum2.addArmaAtaque(pez);
            marenostrum3.addArmaAtaque(pez);
        }else{
            Martillo pluma = new Martillo("Pluma");
            marenostrum2.addArmaAtaque(pluma);
            marenostrum3.addArmaAtaque(pluma);
        }

        if (aleMar2 == 1){
            Casco gorra = new Casco("Gorra");
            marenostrum2.addArmaDefensa(gorra);
            marenostrum3.addArmaDefensa(gorra);
        }else {
            Armadura lata = new Armadura("Lata");
            marenostrum2.addArmaDefensa(lata);
            marenostrum3.addArmaDefensa(lata);
        }

        Rompehielo rp = new Rompehielo("pedro", 1000);

        rp.atacar(gob3);

        Arco lince = new Arco("lince");

        rp.addArmaAtaque(lince);

        lince.atacar(gob3);

        Goblin gob9 = new Goblin("pedro", "sevilla", 10);
        Casco gorra = new Casco("gorrin");
        Escudo lata = new Escudo("Lata");
        Martillo mart = new Martillo("martin");
        Hacha hc = new Hacha("hacha");

        gob9.addArmaDefensa(lata);

        hc.atacar(gob9);
        mart.atacar(gob9);
        lince.atacar(gob9);

        Goblin gob0 = new Goblin("pedro", "sevilla", 10);
        Armadura papelin = new Armadura("papelin");
        gob0.addArmaDefensa(papelin);

        mart.atacar(gob0);
        hc.atacar(gob0);

        WarhammerPersonaje.toNumPersonajes();

        // || --- |Nota para obtener de un 5 a un 8| --- ||





    }
}