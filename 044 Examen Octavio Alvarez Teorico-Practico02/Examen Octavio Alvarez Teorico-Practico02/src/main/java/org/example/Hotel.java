package org.example;

public class Hotel {

    private int id_hotel;
    private String nombre_hotel;
    private String director;
    private int estrellas;
    private int anio;
    private String direccion;
    private Tipo tipo;


    public Hotel(int id_hotel, String nombre_hotel, String director, int anio, int estrellas, String direccion, Tipo tipo) {
        this.id_hotel = id_hotel;
        this.nombre_hotel = nombre_hotel;
        this.director = director;
        this.estrellas = estrellas;
        this.anio = anio;
        this.direccion = direccion;
        this.tipo = tipo;
    }

    public Hotel(int id_hotel, String nombre_hotel, String director, int anio, int estrellas, String direccion) {
        this.id_hotel = id_hotel;
        this.nombre_hotel = nombre_hotel;
        this.director = director;
        this.estrellas = estrellas;
        this.anio = anio;
        this.direccion = direccion;
    }

    public int getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public String getNombre_hotel() {
        return nombre_hotel;
    }

    public void setNombre_hotel(String nombre_hotel) {
        this.nombre_hotel = nombre_hotel;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "◄ HOTEL ► [" + "ID: " + id_hotel + ", NOMBRE: '" + nombre_hotel + ", DIRECTOR: '" + director + ", ESTRELLAS: " + estrellas + ", AÑIO: " + anio + ", DIRECCION: '" + direccion + ", TIPO: " + tipo + ']';
    }
}
