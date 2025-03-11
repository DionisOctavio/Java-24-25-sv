package postgre;

public class Main {
    public static void main(String[] args) {

        Singleton.getInstance();

        PeliculaDAO pdao = new PeliculaDAO();
        GeneroDAO gdao = new GeneroDAO();

        pdao.findAll();

        pdao.find(1);
        pdao.find(21);
        pdao.find(9);

        Pelicula peliculaActualizada = new Pelicula(1, "Suzume", "Makoto Shinkai", "CoMix Wave Films", 2021, new Genero(1, "Fantasía"), 122);

        pdao.update(peliculaActualizada);

        Pelicula peliculaActualizada2 = new Pelicula(1, "Suzume", "Makoto Shinkai", "CoMix Wave Films", 2022, new Genero(1, "Fantasía"), 122);

        pdao.update(peliculaActualizada2);

        gdao.add(new Genero(9, "Deporte"));

        Pelicula nuevaPelicula = new Pelicula(35, "Haikyuu!!: Battle at the Garbage Dump", "Susumu Mitsunaka", "Production I.G", 2024, new Genero(9, "Deporte"), 85);

        pdao.add(nuevaPelicula);

        pdao.findAll();

        gdao.findAll();
    }
}