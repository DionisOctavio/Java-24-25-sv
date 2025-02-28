package org.example;


public class Pelicula {
    private int id;
    private String titulo;
    private int anio;
    private String demografia;
    private String genero;
    private int pegi;

    public Pelicula(int id, String titulo, int anyo, String demografia, String genero, int pegi) {
        this.id = id;
        this.titulo = titulo;
        this.anio = anyo;
        this.demografia = demografia;
        this.genero = genero;
        this.pegi = pegi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDemografia() {
        return demografia;
    }

    public void setDemografia(String demografia) {
        this.demografia = demografia;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getPegi() {
        return pegi;
    }

    public void setPegi(int pegi) {
        this.pegi = pegi;
    }

    @Override
    public String toString() {
        return "🎬 Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", anio=" + anio +
                ", demografia='" + demografia + '\'' +
                ", genero='" + genero + '\'' +
                ", pegi=" + pegi +
                '}';
    }
}
