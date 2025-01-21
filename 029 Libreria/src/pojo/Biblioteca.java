package pojo;

public class Biblioteca {
    private static final int CAPACIDAD = 3;
    private static Libro[] libros = new Libro[CAPACIDAD];
    private static int contadorLibros = 0;

    public void agregarLibro(Libro libro) {
        if (contadorLibros < CAPACIDAD) {
            libros[contadorLibros] = libro;
            contadorLibros++;
            System.out.println("El libro aun cabe");
        }else{
            System.out.println("El libro no cabe");
        }
    }

    public void listarLibro(){
        //foreach para objetos
        for (Libro libro:libros) {
            System.out.println(libro.toString());
        }

    }

    public Libro buscarLibro(String titulo){
        for (Libro libro:libros) {
            if (libro.getTitulo().equals(titulo));
            return libro;
        }
        return null;
    }

    public Libro pestarLibro(String titulo){
        Libro libro = buscarLibro(titulo);
        if (libro.isDisponible()) {
            libro.setDisponible(false);
            System.out.println("El libro ha sido prestado.");
        } else {
            System.out.println("El libro no está disponible.");
        }
        return libro;
    }

    public Libro devolverLibro(String titulo){
        Libro libro = buscarLibro(titulo);
        if (!libro.isDisponible()) {
            libro.setDisponible(true);
            System.out.println("El libro ha sido devuelto.");
        }
        return libro;
    }

}
