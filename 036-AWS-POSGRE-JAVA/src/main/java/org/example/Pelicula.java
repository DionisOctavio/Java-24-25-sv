package org.example;

public class Pelicula {
    private int id;
    private String titulo;
    private String director;
    private int anio;

    public Pelicula(int id, String titulo, String director, int anio) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.anio = anio;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDirector() {
        return director;
    }

    public int getAnio() {
        return anio;
    }


    @Override
    public String toString() {
        return "🎬 ID: " + id + " | 🎥 " + titulo + " | 🎬 " + director + " | 📅 " + anio + " | ";
    }
}

