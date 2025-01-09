package pojo;

public class Magdalena {

    private String id;
    private String tamaño;
    private String sabor;
    private char decorada;


    public Magdalena(String id, String sabor, String tamaño, char decorada) {
        this.id = id;
        this.sabor = sabor;
        this.tamaño = tamaño;
        this.decorada = decorada;
    }

    public String getId() {
        return id;
    }

    public String addSabor() {
        return sabor;
    }

    public String addTamaño() {
        return tamaño;
    }

    public char addDecorada() {
        return decorada;
    }

    public void printMagdalena(){
        System.out.println(id + ": Sabor: " + sabor + ", Tamaño: " + tamaño + ", Decorada: " + decorada);
    }

}


