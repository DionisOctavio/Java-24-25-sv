package model.dao;

import model.entities.Genero;
import model.factory.DatabaseFactory;
import model.motorsql.MotorSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GeneroDAO implements DAO<Genero, Integer> {

    private MotorSQL motorSql;

    public GeneroDAO(String db) {
        motorSql = DatabaseFactory.getDatabase(db);
    }

    @Override
    public int add(Genero bean) {
        return 0;
    }

    @Override
    public int delete(Integer e) {
        return 0;
    }

    @Override
    public int update(Genero bean) {
        return 0;
    }

    @Override
    public ArrayList<Genero> findAll(Genero bean) {
        ArrayList<Genero> generos = new ArrayList<>();
        String sql = "SELECT * FROM GENERO WHERE 1=1";

        try {
            motorSql.connect();
            if (bean != null) {
                if (bean.getIdGenero() != 0) {
                    sql += " AND ID_GENERO = '" + bean.getIdGenero() + "'";
                }
                if (bean.getNombre() != null) {
                    sql += " AND NOMBRE = '" + bean.getNombre() + "'";
                }
            }

            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {
                Genero genero = new Genero();

                genero.setIdGenero(rs.getInt(1));
                genero.setNombre(rs.getString(2));


                generos.add(genero);

            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return generos;
    }
}
