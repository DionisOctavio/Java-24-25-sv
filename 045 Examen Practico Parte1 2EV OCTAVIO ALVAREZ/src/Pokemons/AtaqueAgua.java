package Pokemons;

public class AtaqueAgua implements EstrategiaAtaque{

    protected String nombreEstrategia;

    public AtaqueAgua(String nombreEstrategia) {
        this.nombreEstrategia = nombreEstrategia;
    }

    @Override
    public void atacar(Pokemon enemigo) {
        System.out.println("Estrategia: " + nombreEstrategia);
        System.out.println("💧 Ataque de Agua golpea a " + enemigo.getNombre() + "!");
        enemigo.defender(30);
    }

}
