package postgre;

public class Main {
    public static void main(String[] args) {

        Singleton.getInstance();

        PeliculaDAO pdao = new PeliculaDAO();
        GeneroDAO gdao = new GeneroDAO();

        pdao.findAll();

        pdao.find(1);

    }
}