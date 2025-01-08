package pojo;

public class Magdalena {
    String sabor;
    String color;

    public Magdalena(String sabor, String color) {
        System.out.println(sabor);
        System.out.println(sabor);

        this.color = color;
        this.sabor = sabor;
    }

    public void hornear(){
        System.out.println("Estoy Horneando");
        System.out.println("Sabor: " + this.sabor);
    }
}
