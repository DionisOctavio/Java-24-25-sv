package model.dao;

import model.entities.Libro;
import model.factory.DatabaseFactory;
import model.motorsql.MotorSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LibroDAO implements DAO<Libro, Integer> {

    private MotorSQL motorSql;

    public LibroDAO(String db) {
        motorSql = DatabaseFactory.getDatabase(db);
    }


    @Override
    public int add(Libro bean) {
        return 0;
    }

    @Override
    public int delete(Integer e) {
        return 0;
    }

    @Override
    public int update(Libro bean) {
        return 0;
    }

    @Override
    public ArrayList<Libro> findAll(Libro bean) {
        ArrayList<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM LIBRO WHERE 1=1";

        try {
            motorSql.connect();
            if (bean != null) {
                if (bean.getIdLibro() != 0) {
                    sql += " AND ID_LIBRO = '" + bean.getIdLibro() + "'";
                }
                if (bean.getNombre() != null) {
                    sql += " AND NOMBRE = '" + bean.getNombre() + "'";
                }
            }

            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {
                Libro libro = new Libro();

                libro.setIdLibro(rs.getInt(1));
                libro.setNombre(rs.getString(2));


                libros.add(libro);

            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return libros;
    }

    public ArrayList<Libro> findByGenero(String genero){
        ArrayList<Libro> libros = new ArrayList<>();
        String sql = "SELECT l.id_libro, l.nombre " +
                "FROM LIBRO l " +
                "JOIN LIBRO_GENERO lg ON l.id_libro = lg.id_libro " +
                "JOIN GENERO g ON lg.id_genero = g.id_genero " +
                "WHERE LOWER(g.nombre) = LOWER('" + genero + "')";

        System.out.println(sql);
        try{
            motorSql.connect();
            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {
                Libro libro = new Libro();
                libro.setNombre(rs.getString(2));

                libros.add(libro);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return libros;
    }
}
