package model.entities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Equipo {

    private int id_equipo;
    private String nombre_equipo;
    private int id_categoria;

    public Equipo(int id_equipo, String nombre_equipo, int id_categoria) {
        this.id_equipo = id_equipo;
        this.nombre_equipo = nombre_equipo;
        this.id_categoria = id_categoria;
    }

    public Equipo(){}

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public static String toArrayJSon(ArrayList<Equipo> equipo) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String resp = gson.toJson(equipo);
        return resp;
    }

}
