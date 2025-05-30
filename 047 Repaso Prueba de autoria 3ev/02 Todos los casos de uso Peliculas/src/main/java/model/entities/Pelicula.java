package model.entities;

import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Pelicula {

    private int id_pelicula;
    private String titulo;
    private int anio;
    private int id_categoria;

    public Pelicula(int id_pelicula, String titulo, int anio, int id_categoria) {
        this.id_pelicula = id_pelicula;
        this.titulo = titulo;
        this.anio = anio;
        this.id_categoria = id_categoria;
    }

    public Pelicula() {}

    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id_pelicula=" + id_pelicula +
                ", titulo='" + titulo + '\'' +
                ", anio=" + anio +
                ", id_categoria=" + id_categoria +
                '}';
    }

    public static String fromArrayToJson(ArrayList<Pelicula> peliculas) {
        String resp = "[";
        for (Pelicula pelicula : peliculas) {
            resp += "{"
                    + "'id_pelicula':'" + pelicula.getId_pelicula() + "',"
                    + "'titulo':'" + pelicula.getTitulo() + "', "
                    + "'anio':'" + pelicula.getAnio() + "',"
                    + "'id_categoria':" + pelicula.getId_categoria() + "}";
            resp += ",";
        }
        resp = resp.substring(0, resp.length() - 1);
        resp += "]";
        return resp;
    }

    public static String toArrayJSon(ArrayList<Pelicula> peliculas) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String resp = gson.toJson(peliculas);
        return resp;
    }
}
