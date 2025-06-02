package model.dao;

import model.entities.Categoria;
import model.entities.Equipo;
import model.factory.DatabaseFactory;
import model.motorsql.MotorSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaDAO implements DAO<Categoria, Integer> {

    private MotorSQL motorSql;

    public CategoriaDAO(String db){
        motorSql = DatabaseFactory.getDatabase(db);
    }


    @Override
    public int add(Categoria bean) {
        return 0;
    }

    @Override
    public int delete(Integer e) {
        return 0;
    }

    @Override
    public int update(Categoria bean) {
        return 0;
    }

    @Override
    public ArrayList<Categoria> findAll(Categoria bean) {
        ArrayList<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM CATEGORIA";
        System.out.println(sql);
        try {
            motorSql.connect();
            if (bean != null) {
                if (bean.getId_categoria() != 0) {
                    sql += "AND ID_CATEGORIA='" + bean.getId_categoria() + "'";
                }
                if (bean.getNombre_categoria() != null) {
                    sql += "AND NOMBRE_CATEGORIA='" + bean.getNombre_categoria() + "'";
                }
            }

            System.out.println(sql);
            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {
                Categoria categoria = new Categoria();

                categoria.setId_categoria(rs.getInt(1));
                categoria.setNombre_categoria(rs.getString(2));

                categorias.add(categoria);

            }
        }catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return categorias;
    }
}
