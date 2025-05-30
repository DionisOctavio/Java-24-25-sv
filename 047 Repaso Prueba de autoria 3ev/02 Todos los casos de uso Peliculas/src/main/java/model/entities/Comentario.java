package model.entities;

import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Comentario {

    private int id_comentario;
    private String texto;
    private int id_usuario;
    private int id_pelicula;

    public Comentario(int id_comentario, String texto, int id_usuario, int id_pelicula) {
        this.id_comentario = id_comentario;
        this.texto = texto;
        this.id_usuario = id_usuario;
        this.id_pelicula = id_pelicula;
    }

    public int getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(int id_comentario) {
        this.id_comentario = id_comentario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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

    @Override
    public String toString() {
        return "Comentario{" +
                "id_comentario=" + id_comentario +
                ", texto='" + texto + '\'' +
                ", id_usuario=" + id_usuario +
                ", id_pelicula=" + id_pelicula +
                '}';
    }

    public static String fromArrayToJson(ArrayList<Comentario> comentarios) {
        String resp = "[";
        for (Comentario c : comentarios) {
            resp += "{"
                    + "'id_comentario':'" + c.getId_comentario() + "',"
                    + "'texto':'" + c.getTexto().replace("'", "\\'") + "',"
                    + "'id_usuario':'" + c.getId_usuario() + "',"
                    + "'id_pelicula':'" + c.getId_pelicula() + "'}";
            resp += ",";
        }
        if (!comentarios.isEmpty()) {
            resp = resp.substring(0, resp.length() - 1); // Quitar la última coma
        }
        resp += "]";
        return resp;
    }

    public static String toArrayJson(ArrayList<Comentario> comentarios) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        return gson.toJson(comentarios);
    }
}
