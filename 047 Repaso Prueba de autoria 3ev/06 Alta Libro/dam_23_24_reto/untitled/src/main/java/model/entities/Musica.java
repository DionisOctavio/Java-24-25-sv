package model.entities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
public class Musica {

    private int id_musica;
    private String nombre;

    public Musica(int id_musica, String nombre) {
        this.id_musica = id_musica;
        this.nombre = nombre;
    }

    public Musica (){}

    public int getId_musica() {
        return id_musica;
    }

    public void setId_musica(int id_musica) {
        this.id_musica = id_musica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static String fromObjectToJSON(Musica musica) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String resp = gson.toJson(musica);
        return resp;
    }

    public static String toArrayJSon(ArrayList<Musica> musica) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(musica);

        return resp;
    }

}
