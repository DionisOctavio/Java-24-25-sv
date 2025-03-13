package Pokemons;

public class Charizard extends Charmeleon {

    public Charizard(String nombre, int nivel, int energia) {
        super(nombre, nivel, energia);
    }

    @Override
    public void atacar(Pokemon enemigo) {
        super.atacar(enemigo);
    }

    @Override
    public void defender(int dano) {
        super.defender(dano);
    }

    @Override
    public Pokemon evolucionar() {
        System.out.println("AMIGO, AMIGO, NO PUEDO EVOLUCIONAR MAS, ESTOY EN MI PRIME");
        return null;
    }

    @Override
    public Pokemon involucionar() {
        Charmeleon charmeleon = new Charmeleon("CHARMANDER", 50, 500);
        System.out.println("El Pokemon Charmeleon Ha involucionado a este Charmander: [" + charmeleon + "]");
        return charmeleon;
    }

    @Override
    public String toString() {
        return "Charizard{" +
                "nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", energia=" + energia +
                ", Tipo=" + tipo +
                '}';
    }

}
