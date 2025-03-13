package Pokemons;

public class Charmander extends PokemonFuego {


    public Charmander(String nombre, int nivel, int energia) {
        super(nombre, nivel, energia);
    }

    @Override
    public void atacar(Pokemon enemigo) {
        System.out.println("Ataque de Fuego impacta a " + enemigo.getNombre() + "!");
        enemigo.defender(25);
        super.estrategiaAtaque.atacar(enemigo);
    }

    @Override
    public void defender(int dano) {
        energia = energia - dano;
        System.out.println("ENERGIA ACTUAL: " + energia);
    }

    @Override
    public Pokemon evolucionar() {
        Charmeleon charmeleon = new Charmeleon("CHARMILEON", 60, 1000);
        System.out.println("El Pokemon Charmander Ha evolucionado a este Charmeleon: [" + charmeleon + "]");
        return charmeleon;
    }

    @Override
    public Pokemon involucionar() {
        System.out.println("ERES TONTICO YA NO PUEDO BAJAR MAS QUE ME VOY A VILLA HUEVO");
        return null;
    }

    @Override
    public String toString() {
        return "Charmander{" +
                "nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", energia=" + energia +
                ", Tipo=" + tipo +
                '}';
    }
}
