package model.entities;

import java.util.ArrayList;

public class Categoria {

    private int id_categoria;
    private String nombre;

    public Categoria(int id_categoria, String nombre) {
        this.id_categoria = id_categoria;
        this.nombre = nombre;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static String fromArrayToJson(ArrayList<Categoria> categorias) {
        StringBuilder resp = new StringBuilder("[");
        for (Categoria categoria : categorias) {
            resp.append("{")
                    .append("\"id_categoria\":").append(categoria.getId_categoria()).append(",")
                    .append("\"nombre\":\"").append(categoria.getNombre()).append("\"")
                    .append("},");
        }
        if (!categorias.isEmpty()) {
            resp.setLength(resp.length() - 1); // elimina la última coma
        }
        resp.append("]");
        return resp.toString();
    }


}
