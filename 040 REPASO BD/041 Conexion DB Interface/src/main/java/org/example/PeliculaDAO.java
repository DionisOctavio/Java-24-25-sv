package org.example;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

        String sql = "SELECT * FROM peliculas WHERE id = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Pelicula pelicula = new Pelicula(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("descripcion"),
                        rs.getInt("anio")
                );
                System.out.println("🎬 Película encontrada: " + pelicula);
            } else {
                System.out.println("❌ No se encontró la película con ID " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void findAll() {

    }
}
