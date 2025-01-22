import pojo.Lista;
import pojo.Pelicula;

public class Main {
    public static void main(String[] args) {

        Pelicula pelicula1 = new Pelicula("Guardianes de la noche: Tren infinito", "Haruo Sotozaki", "Animación", 2020);
        Pelicula pelicula2 = new Pelicula("Akira", "Katsuhiro Otomo", "Ciencia Ficción", 1988);
        Pelicula pelicula3 = new Pelicula("Mi vecino Totoro", "Hayao Miyazaki", "Fantástico", 1988);
        Pelicula pelicula4 = new Pelicula("El viaje de Chihiro", "Hayao Miyazaki", "Fantasía", 2001);

        Lista lista = new Lista();

        lista.agregarPelicula(pelicula1);
        lista.agregarPelicula(pelicula2);
        lista.agregarPelicula(pelicula3);
        lista.agregarPelicula(pelicula4);

        lista.mostrarPeliculasLista();

        lista.buscarPeliculaLista("El viaje de Chihiro");
    }
}