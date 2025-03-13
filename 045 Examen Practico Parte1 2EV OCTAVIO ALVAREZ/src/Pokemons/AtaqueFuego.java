package Pokemons;

public class AtaqueFuego implements EstrategiaAtaque {

    protected String nombreEstrategia;

    public AtaqueFuego(String nombreEstrategia) {
        this.nombreEstrategia = nombreEstrategia;
    }

    @Override
    public void atacar(Pokemon enemigo) {
        System.out.println("Estrategia: " + nombreEstrategia);
        System.out.println("🔥 Ataque de Fuego impacta a " + enemigo.getNombre() + "!");
        enemigo.defender(25);
    }

}
