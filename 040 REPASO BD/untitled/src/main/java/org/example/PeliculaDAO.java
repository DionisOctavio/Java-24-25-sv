package org.example;

public class PeliculaDAO implements DAO {

    @Override
    public void add(Pelicula pelicula) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Pelicula pelicula) {

    }

    @Override
    public void find(int id) {

        ConexionPostGre conex = Singleton.getInstance();
        Connection conn = conex.getConnection();
        Statement st = conn.createStatement();
        ResultSet lstDatos = st.
                executeQuery("SELECT * FROM PELICULAS");

    }

    @Override
    public void findAll() {

    }
}
