package Pokemons;

public class Squirtle extends PokemonAgua {

    public Squirtle(String nombre, int nivel, int energia) {
        super(nombre, nivel, energia);
    }

    @Override
    public void atacar(Pokemon enemigo) {
        System.out.println("Ataque de Agua impacta a " + enemigo.getNombre() + "!");
        enemigo.defender(30);
    }

    @Override
    public void defender(int dano) {
        energia = energia - dano;
        System.out.println("ENERGIA ACTUAL: " + energia);
    }

    @Override
    public Pokemon evolucionar() {
        return null;
    }

    @Override
    public Pokemon involucionar() {
        System.out.println("ERES TONTICO YA NO PUEDO BAJAR MAS QUE ME VOY A VILLA HUEVO");
        return null;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", energia=" + energia +
                ", Tipo=" + tipo +
                '}';
    }

}
