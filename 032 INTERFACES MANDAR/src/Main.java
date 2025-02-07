import pojo.AlmacenMusica;
import pojo.Cancion;

public class Main {
    public static void main(String[] args) {

        AlmacenMusica almacen = new AlmacenMusica();

        Cancion cancion1 = new Cancion ("Despacito", "Luis Fonsi", "POP");
        Cancion cancion2 = new Cancion ("Como Camaron", "Estopa", "Rock");
        Cancion cancion3 = new Cancion ("Life is a Highway", "Rascal Flatts", "Rock");
        Cancion cancion4 = new Cancion ("Waka Waka", "Shakira", "POP");

        almacen.addCancion(cancion1);
        almacen.addCancion(cancion2);
        almacen.addCancion(cancion3);
        almacen.addCancion(cancion4);

        almacen.deleteCancion(cancion4);

        almacen.updateCancion(cancion3);

        almacen.imprimir();

    }
}