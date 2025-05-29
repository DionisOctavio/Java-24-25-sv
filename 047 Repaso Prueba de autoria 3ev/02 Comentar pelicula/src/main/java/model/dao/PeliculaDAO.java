package model.dao;

import model.entities.Pelicula;
import model.factory.dbFactory;
import model.motorsql.MotorSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import static java.sql.DriverManager.getConnection;

public class PeliculaDAO implements DAO<Pelicula, Integer> {

    private MotorSQL motorSQL;

    public PeliculaDAO(String db) {
        motorSQL = dbFactory.getDataBase(db);
    }

    @Override
    public ArrayList<Pelicula> findAll(Pelicula bean) {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        String sql = "select * from pelicula";

        try{

            motorSQL.connect();
            if (bean != null) {
                if (bean.getId_pelicula() != 0){
                    sql += "AND ID_PELICULA='" + bean.getId_pelicula() + "'";
                }
                if (bean.getTitulo() != null){
                    sql += "AND TITULO='" + bean.getTitulo() + "'";
                }
                if (bean.getAnio() != 0) {
                    sql += "AND ANIO=" + bean.getAnio();
                }
                if (bean.getId_categoria() != 0) {
                    sql += "AND ID_CATEGORIA='" + bean.getId_categoria() + "'";
                }
            }

            System.out.println(sql);
            ResultSet rs = motorSQL.executeQuery(sql);

            while (rs.next()) {
                Pelicula pelicula = new Pelicula();

                pelicula.setId_pelicula(rs.getInt(1));
                pelicula.setTitulo(rs.getString(2));
                pelicula.setAnio(rs.getInt(3));
                pelicula.setId_categoria(rs.getInt(4));

                peliculas.add(pelicula);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return peliculas;
    }

    public ArrayList<Pelicula> findAllByCategory(int id_categoria) {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        String sql = "SELECT * FROM pelicula WHERE id_categoria = " + id_categoria;

        try {
            motorSQL.connect();
            ResultSet rs = motorSQL.executeQuery(sql);

            while (rs.next()) {
                Pelicula pelicula = new Pelicula();

                pelicula.setId_pelicula(rs.getInt("id_pelicula"));
                pelicula.setTitulo(rs.getString("titulo"));
                pelicula.setAnio(rs.getInt("anio"));
                pelicula.setId_categoria(rs.getInt("id_categoria"));

                peliculas.add(pelicula);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener películas por categoría: " + e.getMessage());
        } finally {
            motorSQL.disconnect();
        }

        return peliculas;
    }

    public ArrayList<Pelicula> findAllByTitle(String titulo) {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        String sql = "SELECT id_pelicula, titulo, anio, id_categoria FROM pelicula WHERE titulo ILIKE '%" + titulo + "%'";

        try {

            motorSQL.connect();
            ResultSet rs = motorSQL.executeQuery(sql);

            while (rs.next()) {
                Pelicula pelicula = new Pelicula();
                pelicula.setId_pelicula(rs.getInt("id_pelicula"));
                pelicula.setTitulo(rs.getString("titulo"));
                pelicula.setAnio(rs.getInt("anio"));
                pelicula.setId_categoria(rs.getInt("id_categoria"));
                peliculas.add(pelicula);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            motorSQL.disconnect();
        }

        return peliculas;
    }

    @Override
    public int add(Pelicula pelicula) {
        int result = 0;

        // Construimos la consulta SQL, ojo con las comillas en texto
        String sql = "INSERT INTO pelicula (titulo, anio, id_categoria) VALUES ('"
                + pelicula.getTitulo().replace("'", "''") + "', "  // escapa comillas simples para evitar errores
                + pelicula.getAnio() + ", "
                + pelicula.getId_categoria() + ")";

        try {
            motorSQL.connect();

            // Ejecutamos el update (insert, update, delete) con execute()
            result = motorSQL.execute(sql);

        } catch (Exception e) {
            System.out.println("Error al añadir película: " + e.getMessage());
        } finally {
            motorSQL.disconnect();
        }

        return result;
    }






    @Override
    public int delete(Integer e) {
        return 0;
    }

    @Override
    public int update(Pelicula bean) {
        return 0;
    }
}
