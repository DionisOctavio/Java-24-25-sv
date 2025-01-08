package pojo;

public class Magdalena {

    String tamaño;
    String sabor;

    String horneado;
    String estado;

    public Magdalena(String sabor, String tamaño) {
        this.sabor = sabor;
        this.tamaño = tamaño;
    }

    public void estado() {
        this.estado = "Decorado";
        this.estado = estado;
        System.out.println("Magdalena Decorada");
    }

    public void decorar() {
        System.out.println(this.sabor);
        System.out.println(this.tamaño);
    }
}
