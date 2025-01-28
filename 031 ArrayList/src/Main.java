import pojo.Almacen;
import pojo.Cancion;

public class Main {
    public static void main(String[] args) {
        Almacen almacenCanciones = new Almacen();

        Cancion cancion1 = new Cancion ("Despacito", "Luis Fonsi", "POP");
        Cancion cancion2 = new Cancion ("Como Camaron", "Estopa", "Rock");
        Cancion cancion3 = new Cancion ("Life is a Highway", "Rascal Flatts", "Rock");
        Cancion cancion4 = new Cancion ("Waka Waka", "Shakira", "POP");

        almacenCanciones.addCancion(cancion1);
        almacenCanciones.addCancion(cancion2);
        almacenCanciones.addCancion(cancion3);
        almacenCanciones.addCancion(cancion4);

        almacenCanciones.deleteCancion(cancion2);

        almacenCanciones.mostrarCancion();
    }
}