package model.dao;
import model.entities.Categoria;
import model.entities.Comentario;
import model.entities.Pelicula;
import model.factory.dbFactory;
import model.motorsql.MotorSQL;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.util.ArrayList;


public class CategoriaDAO implements DAO {

    private MotorSQL motorSQL;

    public CategoriaDAO(String db) {
        motorSQL = dbFactory.getDataBase(db);
    }


    @Override
    public int add(Object bean) {
        return 0;
    }

    @Override
    public int delete(Integer e) {
        return 0;
    }

    @Override
    public int update(Object bean) {
        return 0;
    }

    @Override
    public ArrayList<Categoria> findAll(Object bean) {
        ArrayList<Categoria> lista = new ArrayList<>();

        String sql = "SELECT * FROM CATEGORIA";

        try {
            motorSQL.connect();
            ResultSet rs = motorSQL.executeQuery(sql);

            while (rs.next()) {
                Categoria c = new Categoria(
                        rs.getInt("id_categoria"),
                        rs.getString("nombre")
                );
                lista.add(c);
            }

        } catch (SQLException e) {
            System.err.println("Error en findAll de CategoriaDAO: " + e.getMessage());
        } finally {
            motorSQL.disconnect();
        }

        return lista;
    }



}
