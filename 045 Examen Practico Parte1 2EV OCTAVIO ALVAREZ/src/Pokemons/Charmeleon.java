package Pokemons;

public class Charmeleon extends Charmander {
    public Charmeleon(String nombre, int nivel, int energia) {
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
        Charizard charizard = new Charizard("CHARIZARD", 80, 8000);
        System.out.println("El Pokemon Charmander Ha evolucionado a este Charmeleon: [" + charizard + "]");
        return charizard;
    }

    @Override
    public Pokemon involucionar() {
        Charmander charmander = new Charmander("CHARMANDER", 50, 500);
        System.out.println("El Pokemon Charmeleon Ha involucionado a este Charmander: [" + charmander + "]");
        return charmander;
    }

    @Override
    public String toString() {
        return "Charmeleon{" +
                "nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", energia=" + energia +
                ", Tipo=" + tipo +
                '}';
    }

}
