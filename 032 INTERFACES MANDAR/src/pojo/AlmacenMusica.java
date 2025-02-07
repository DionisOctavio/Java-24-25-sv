package pojo;


import java.util.ArrayList;
import java.util.Scanner;

public class AlmacenMusica implements IEstanteria{
    ArrayList<Cancion> lstCanciones;

    /* public AlmacenMusica(ArrayList<Cancion> lstCanciones) {
        this.lstCanciones = lstCanciones;
    } */
    public AlmacenMusica() {
        this.lstCanciones = new ArrayList<Cancion>();
    }

    @Override
    public void addCancion(Cancion c) {
        this.lstCanciones.add(c);
        System.out.println("Cancion agregada exitosamente: " + c);
    }

    @Override
    public void updateCancion(Cancion c) {
        Scanner leer= new Scanner(System.in);
        for (Cancion cancion : lstCanciones) {
            if (cancion.equals(c)) {

                // TITULO
                System.out.print("Ingrese el nuevo nombre de la canción: ");
                String nombre = leer.nextLine();

                cancion.setNombre(nombre);


                // ARTISTA

                System.out.print("Ingrese el nuevo artista de la canción: ");
                String artista = leer.nextLine();

                cancion.setArtista(artista);


                // GENERO

                System.out.print("Ingrese el nuevo genero de la canción: ");
                String genero = leer.nextLine();

                cancion.setGenero(genero);


                System.out.println("Canción actualizada exitosamente: " + cancion);
                return;
            }
        }
        System.out.println("Canción no encontrada en la lista: " + c);
    }

    @Override
    public void deleteCancion(Cancion c) {
        this.lstCanciones.remove(c);
        System.out.println("Cancion eliminada exitosamente: " + c);
    }

    @Override
    public void imprimir() {
        for (Cancion cancion: lstCanciones) {
            System.out.println(cancion);
        }
    }
}
