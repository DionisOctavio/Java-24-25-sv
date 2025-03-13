package Pokemons;

public abstract class Pokemon implements EstrategiaAtaque {
    protected String nombre;
    protected int nivel;
    protected int energia;
    public static final int MAX_NIVEL = 1000;

    protected EstrategiaAtaque estrategiaAtaque;

    public Pokemon(String nombre, int nivel, int energia) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.energia = energia;
    }

    public void setEstrategiaAtaque(EstrategiaAtaque estrategia) {
        this.estrategiaAtaque = estrategia;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract void atacar(Pokemon enemigo);
    public abstract void defender(int dano);
    public abstract Pokemon evolucionar();

    public abstract Pokemon involucionar();

    public final void subirNivel() {
        if (nivel < MAX_NIVEL){
            System.out.println("HAS SUBIDO +1 EL NIVEL");
            nivel++;
        }else {
            System.out.println("YA HAS ALCANZADO EL MAXIMO NIVEL");
        }
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", energia=" + energia +
                '}';
    }
}
