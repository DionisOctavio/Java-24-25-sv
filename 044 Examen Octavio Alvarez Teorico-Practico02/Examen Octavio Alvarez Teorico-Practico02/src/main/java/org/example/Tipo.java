package org.example;

public class Tipo {

    private int id_tipo;
    private String nombre_tipo;

    public Tipo(int id_tipo, String nombre_tipo) {
        this.id_tipo = id_tipo;
        this.nombre_tipo = nombre_tipo;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
    }

    @Override
    public String toString() {
        return "§ TIPO § [" + "ID: " + id_tipo + ", TIPO: '" + nombre_tipo + ']';
    }
}
