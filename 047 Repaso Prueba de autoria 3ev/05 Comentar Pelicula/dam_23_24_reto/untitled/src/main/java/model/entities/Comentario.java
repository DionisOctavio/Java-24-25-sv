package model.entities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Comentario {

    private int id_comentario;
    private String comentario;
    private int id_usuario;
    private int id_pelicula;

    public Comentario(int id_comentario, String comentario, int id_usuario, int id_pelicula) {
        this.id_comentario = id_comentario;
        this.comentario = comentario;
        this.id_usuario = id_usuario;
        this.id_pelicula = id_pelicula;
    }

    public int getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(int id_comentario) {
        this.id_comentario = id_comentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public static String fromObjectToJSON(Comentario comentario) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String resp = gson.toJson(comentario);
        return resp;
    }

    public static String toArrayJSon(ArrayList<Comentario> comentario) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String resp = gson.toJson(comentario);
        return resp;
    }
}
