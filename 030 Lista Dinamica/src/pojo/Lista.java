package pojo;

import pojo.Pelicula;

public class Lista {
    private Pelicula[] peliculas;
    private int tamanyo;

    //Constructor

    public Lista(){
        this.peliculas = new Pelicula[1];
        this.tamanyo = 0;
    }

    public void agregarPelicula(Pelicula pelicula){
        if (tamanyo == peliculas.length){
            ampliarArray();
            System.out.println("Tamaño ampliado +1");
        }
        peliculas[tamanyo] = pelicula;
        tamanyo++;
        System.out.println("Pelicula agregada com Exito");
    }

    private void ampliarArray(){
        Pelicula[] ampliacionLista = new Pelicula[peliculas.length  + 1];
        for (int i = 0; i < peliculas.length; i++){
            ampliacionLista[i] = peliculas[i];
        }
        peliculas = ampliacionLista;
    }

    public void mostrarPeliculas() {
        for (int i = 0; i < tamanyo; i++) {
            System.out.println(peliculas[i]);
        }
    }


}
