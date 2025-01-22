package pojo;

public class Pelicula {

    private String titulo;
    private String Director;
    private String Genero;
    private int anyo;

    // Constructor

    public Pelicula(String titulo, String director, String genero, int anyo) {
        this.titulo = titulo;
        Director = director;
        Genero = genero;
        this.anyo = anyo;
    }

    // Metodos
    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", Director='" + Director + '\'' +
                ", Genero='" + Genero + '\'' +
                ", anyo='" + anyo + '\'' +
                '}';
    }

    // Metodos GETER AND SETER


    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    // Demas Metodos
}
