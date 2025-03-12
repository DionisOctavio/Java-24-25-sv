package postgre;

public class Main {
    public static void main(String[] args) {

        Singleton.getInstance();

        PeliculaDAO pdao = new PeliculaDAO();
        GeneroDAO gdao = new GeneroDAO();

        pdao.findAll();

        pdao.find(1);

        Pelicula actualizar = new Pelicula(1, "Suzume", "Makoto Shinkai", "CoMix Wave Films", 2022, new Genero(1, "Fantasía"), 123);

        pdao.update(actualizar);

        gdao.findAll();

        Pelicula tucolor = new Pelicula(35, "Tu Color", "Naoku Yamada", "Science SARU", 2024, new Genero(5, "Romance"), 100);

        pdao.add(tucolor);


    }
}