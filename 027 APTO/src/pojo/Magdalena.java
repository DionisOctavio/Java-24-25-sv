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

    public String getSabor() {
        return sabor;
    }

    public String getTamaño() {
        return tamaño;
    }

    public char getDecorada() {
        return decorada;
    }



}


