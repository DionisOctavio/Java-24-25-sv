import Pokemons.*;

public class Main {
    public static void main(String[] args) {

        Pokemon charmander = new Charmander("CHARMANDER", 50, 500);
        System.out.println(charmander.toString());

        // Evolucionar, fíjate en la herencia
        Charmeleon charmeleon = (Charmeleon) charmander.evolucionar();  // Charmander -> Charmeleon
        System.out.println("Después de evolucionar: " + charmeleon.toString());

        Charizard charizard = (Charizard) charmeleon.evolucionar();  // Charmeleon -> Charizard
        System.out.println("Después de evolucionar: " + charizard.toString());

        // Involucionar polimorfismo
        Charmeleon charmeleon1 = (Charmeleon) charizard.involucionar();  // Charizard -> Charmeleon
        System.out.println("Después de involucionar: " + charmeleon1.toString());

        Pokemon squirtle = new Squirtle("SQUIRTLE", 20, 400);

        AtaqueFuego fueg = new AtaqueFuego("Lanza llamas");
        charmander.setEstrategiaAtaque(fueg);

        AtaqueAgua agu = new AtaqueAgua("Pistola Agua");
        squirtle.setEstrategiaAtaque(agu);

        fueg.atacar(squirtle);

        agu.atacar(charmander);

    }
}