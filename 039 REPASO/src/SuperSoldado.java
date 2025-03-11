public class SuperSoldado extends Avenger  {

    public SuperSoldado(String nombre) { super(nombre); }
    @Override
    void atacar() { System.out.println(nombre + " lanza su escudo!"); }

}

