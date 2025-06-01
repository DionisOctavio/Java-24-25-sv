package model.entities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Pelicula  {

    private int id_pelicula;
    private String nombre;
    private int anyo;

    public Pelicula(int id_pelicula, String nombre, int anyo) {
        this.id_pelicula = id_pelicula;
        this.nombre = nombre;
        this.anyo = anyo;
    }

    public Pelicula () {}

    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public static String fromObjectToJSON(Pelicula pelicula) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String resp = gson.toJson(pelicula);
        return resp;
    }

    public static String toArrayJSon(ArrayList<Pelicula> pelicula) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String resp = gson.toJson(pelicula);
        return resp;
    }
}
