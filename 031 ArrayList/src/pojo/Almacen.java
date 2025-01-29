package pojo;

import java.util.ArrayList;

public class Almacen {

    ArrayList<Cancion> LstCanciones = new ArrayList<Cancion>();

    public Almacen() {
        this.LstCanciones = new ArrayList<Cancion>();
    }

    public void addCancion(Cancion cancion) {
        this.LstCanciones.add(cancion);
        System.out.println("Cancion agregada exitosamente: " + cancion);
    }

    public void deleteCancion(Cancion cancion) {
        this.LstCanciones.remove(cancion);
        System.out.println("Cancion eliminada exitosamente: " + cancion);
    }

    public void mostrarCancion() {
        for (Cancion cancion: LstCanciones) {
            System.out.println(cancion);
        }
    }

}
