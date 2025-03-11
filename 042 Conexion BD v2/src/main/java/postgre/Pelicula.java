package postgre;

import java.util.Objects;

public class Pelicula {

        private int id;
        private String titulo;
        private String director;
        private String estudio;
        private int anio;
        private Genero genero;
        private int duracion;

    public Pelicula(int id, String titulo, String director, String estudio, int anio, Genero genero, int duracion) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.estudio = estudio;
        this.anio = anio;
        this.genero = genero;
        this.duracion = duracion;
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Pelicula \uD83D\uDCD7 [" + "ID: " + id + ", TITULO: " + titulo + ", DIRECTOR: " + director + ", ESTUDIO: " + estudio +
                ", AÑO: " + anio + ", GENERO: " + genero + ", DURACION: " + duracion + "min]";
    }
}
