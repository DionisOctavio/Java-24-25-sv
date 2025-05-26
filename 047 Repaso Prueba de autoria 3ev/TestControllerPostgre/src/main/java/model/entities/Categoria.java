package model.entities;

import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Categoria {
    private int idCategoria;
    private String nombreCategoria;
    private String descripcionCategoria;

    public Categoria() {}

    public Categoria(int idCategoria, String nombreCategoria, String descripcionCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.descripcionCategoria = descripcionCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }

    public static String fromArrayListToJson(ArrayList<Categoria> categorias) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(categorias);
    }

    public static String fromObjectToJson(Categoria categoria) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(categoria);
    }

    public String toJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }

}

