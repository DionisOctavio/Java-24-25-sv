package Pokemons;

public class AtaqueAgua implements EstrategiaAtaque{

    @Override
    public void atacar(Pokemon enemigo) {
        System.out.println("💧 Ataque de Agua golpea a " + enemigo.getNombre() + "!");
        enemigo.defender(30);
    }

}
