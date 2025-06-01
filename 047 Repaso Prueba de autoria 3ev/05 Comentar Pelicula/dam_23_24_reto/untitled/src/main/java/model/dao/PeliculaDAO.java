package model.dao;

import model.entities.Pelicula;
import model.factory.DatabaseFactory;
import model.motorsql.MotorSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PeliculaDAO implements DAO<Pelicula, Integer> {

    private MotorSQL motorSql;

    public PeliculaDAO(String db) {
        motorSql = DatabaseFactory.getDatabase(db);
    }

    @Override
    public int add(Pelicula bean) {
        return 0;
    }

    @Override
    public int delete(Integer e) {
        return 0;
    }

    @Override
    public int update(Pelicula bean) {
        return 0;
    }

    @Override
    public ArrayList<Pelicula> findAll(Pelicula bean) {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        String sql = "select * from pelicula";

        try{

            motorSql.connect();
            if (bean != null) {
                if (bean.getId_pelicula() != 0){
                    sql += "AND ID_PELICULA='" + bean.getId_pelicula() + "'";
                }
                if (bean.getNombre() != null){
                    sql += "AND TITULO='" + bean.getNombre() + "'";
                }
                if (bean.getAnyo() != 0) {
                    sql += "AND ANIO=" + bean.getAnyo();
                }
            }

            System.out.println(sql);
            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {
                Pelicula pelicula = new Pelicula();

                pelicula.setId_pelicula(rs.getInt(1));
                pelicula.setNombre(rs.getString(2));
                pelicula.setAnyo(rs.getInt(3));

                peliculas.add(pelicula);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return peliculas;
    }
}
