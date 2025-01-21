package pojo;

public class Libro {

    //ATRIBUTOS
    private String titulo;
    private String autor;
    private int anyo;
    private boolean disponible;
    public static int contadorLibro;

    // CONSTRUCTOR
    public Libro(String titulo, String autor, int anyo, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.anyo = anyo;
        this.disponible = disponible;
        this.contadorLibro++;
    }
    // METODOS
    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anyo=" + anyo +
                ", disponible=" + disponible +
                '}';
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
