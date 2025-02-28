package org.example;

import java.util.ArrayList;

public class Genero {
    private int id;
    private String nombre;
    private ArrayList<Pelicula> lstPeliculasGenero;

    public Genero(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.lstPeliculasGenero = new ArrayList<>();
    }

    public void agregarPelicula(Pelicula p) {
        lstPeliculasGenero.add(p);
    }

    public void getLstPeliculasGenero() {
        for (Pelicula p : lstPeliculasGenero) {
            System.out.println(p);
        }
    }

}
