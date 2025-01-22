package pojo;

public class Pelicula {

    private String titulo;
    private String director;
    private String genero;
    private int anyo;
    public Pelicula nextPelicula;

    // Constructor

    public Pelicula(String titulo, String director, String genero, int anyo) {
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.anyo = anyo;
        this.nextPelicula = null;
    }

    // Metodos
    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", Director='" + director + '\'' +
                ", Genero='" + genero + '\'' +
                ", anyo='" + anyo + '\'' +
                '}';
    }

    // Metodos GETER AND SETER


    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        director = director;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        genero = genero;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    // Demas Metodos
}
