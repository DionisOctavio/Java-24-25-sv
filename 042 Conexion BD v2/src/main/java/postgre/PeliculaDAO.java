package postgre;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeliculaDAO implements DAO {

    // Método para agregar una película a la base de datos

    @Override
    public void add(Pelicula pelicula) {

    }

    // Método para eliminar una película de la base de datos

    @Override
    public void delete(int id) {

    }

    // Método para actualizar una película existente en la base de datos

    @Override
    public void update(Pelicula pelicula) {

    }

    // Método para buscar una película por su ID

    @Override
    public Pelicula find(int id) {

        // Ponemos esto a null por que si no hay peliculas devolvera null en vez de error
        Pelicula pelicula = null;

        // Creamos nuestro QUERY a BD con nuestra consulta
        String query =
                "SELECT id, titulo, director, estudio, anio, nombre AS genero, duracion, g.id_genero\n" +
                "FROM pelicula p\n" +
                "JOIN genero g ON p.id_genero = g.id_genero\n" +
                "WHERE p.id = ?";

        // Mediante Singelton obtenemos conexion a BD
        Connection conn = Singleton.getInstance().getConnection();

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {

                    Genero genero = new Genero(
                            rs.getInt("id_genero"),
                            rs.getString("genero"));

                    pelicula = new Pelicula(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("director"),
                            rs.getString("estudio"),
                            rs.getInt("anio"), genero,
                            rs.getInt("duracion"));

                    System.out.println("✅ Película encontrada: " + pelicula.toString());
                } else {
                    System.out.println("⚠️ No se encontró película con ID: " + id);
                }
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al buscar la película: " + e.getMessage());
        }
        return pelicula;
    }

    // Método para listar todas las películas de la base de datos

    @Override
    public void findAll() {

        // Creamos nuestro QUERY a BD con nuestra consulta
        String query =
                "SELECT id, titulo, director, estudio, anio, nombre AS genero, duracion\n" +
                "FROM pelicula p\n" +
                "JOIN genero g ON p.id_genero = g.id_genero\n" +
                "ORDER BY id;";

        // Mediante Singelton obtenemos conexion a BD
        Connection conn = Singleton.getInstance().getConnection();

        try (PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("🎬 LISTA DE TODAS LAS PELICULAS 🎬");
            while (rs.next()) {
                System.out.println("   • " + rs.getInt("id") + " | "
                        + rs.getString("titulo") + " | "
                        + rs.getString("director") + " | "
                        + rs.getString("estudio") + " | "
                        + rs.getInt("anio") + " | "
                        + rs.getString("genero") + " | "
                        + rs.getInt("duracion") + " min"
                );
            }
        } catch (SQLException e) {
            System.out.println("❌ ERROR AL TRAER LAS PELICULAS: " + e.getMessage());
        }

    }


}
