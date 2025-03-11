public class IronMan extends SuperSoldado implements Volador,Tecnologico {

    public IronMan() { super("Iron Man"); }
    @Override
    void atacar() { System.out.println(nombre + " dispara rayos láser!"); }

    @Override
    public void analizar() {
        System.out.println("Iron Man analiza la situación!");
    }

    @Override
    public void volar() {
        System.out.println("Iron Man está volando!");
    }
}
