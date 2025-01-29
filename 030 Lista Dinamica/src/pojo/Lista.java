package pojo;

import pojo.Pelicula;

public class Lista {
    private Pelicula primeraPelicula;

    //Constructor

    public Lista(){
        this.primeraPelicula = null;
    }

    public void agregarPelicula(Pelicula nuevaPelicula){
        if (this.primeraPelicula == null){
            this.primeraPelicula = nuevaPelicula;
        } else {
            Pelicula puntero = primeraPelicula;
            while (puntero.nextPelicula != null){
                puntero = puntero.nextPelicula;
            }
            puntero.nextPelicula = nuevaPelicula;
        }
    }

    public void mostrarPeliculasLista(){
        Pelicula puntero = primeraPelicula;
        System.out.println("Lista de Peliculas");
        System.out.println("******************");
        while (puntero != null){
            System.out.println(puntero);
            puntero = puntero.nextPelicula;
        }
        System.out.println("******************");
    }

    public void buscarPeliculaLista(String titulo){
        Pelicula puntero = primeraPelicula;
        boolean isEncontrado = false;
        while (puntero != null){
            if (titulo.equals(puntero.getTitulo())){
                System.out.println("Tu pelicula esta en: " + puntero);
                System.out.println("*******************************");
                isEncontrado = true;
                break;
            }
            puntero = puntero.nextPelicula;
        }
        if (!isEncontrado){
            System.out.println("No esta tu pelicula");
        }
    }

    public void eliminarPelicula(String titulo){
        if (this.primeraPelicula == null){
            System.out.println("La lista esta vacia");
            return;
        }

        if (titulo.equals(this.primeraPelicula.getTitulo())){
            System.out.println("Pelicula: " + this.primeraPelicula + " eliminada");
            primeraPelicula = primeraPelicula.nextPelicula;
            return;
        }

        Pelicula puntero = primeraPelicula;

        while (puntero.nextPelicula != null){
            if (puntero.nextPelicula.getTitulo().equals(titulo)){
                System.out.println("Pelicula: " + puntero.nextPelicula + " eliminada");
                puntero.nextPelicula = puntero.nextPelicula.nextPelicula;
                return;
            }
            puntero = puntero.nextPelicula;
        }

        System.out.println("Pelicula: " + titulo + " eliminada");

    }

}
