import pojo.Biblioteca;
import pojo.Libro;

public class Main {
    public static void main(String[] args) {
        Libro libro1 = new Libro("El Quijote", "Miguel de Cervantes", 1605, true);
        Libro libro2 = new Libro("1984", "George Orwell", 1949, true);
        Libro libro3 = new Libro("El Principito", "Antoine de Saint-Exupéry", 1943, true);

        System.out.println(Libro.contadorLibro);

        Biblioteca bib = new Biblioteca();

        // Agregar libros a la biblioteca
        bib.agregarLibro(libro1);
        bib.agregarLibro(libro2);
        bib.agregarLibro(libro3);

        // Listar libros
        bib.listarLibro();

        // Buscar y prestar un libro
        bib.pestarLibro("1984");
        bib.listarLibro();

        // Intentar prestar el mismo libro
        bib.pestarLibro("1984");

        // Devolver el libro
        bib.devolverLibro("1984");
        bib.listarLibro();
    }
}